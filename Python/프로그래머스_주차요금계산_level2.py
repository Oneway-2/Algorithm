from datetime import datetime
import math


def solution(fees, records):
    costs = dict()
    parking = dict()
    # print(fees)
    # 기본시간 , 기본요금 , 단위시간 , 단위요금
    savetime, savefee, termtime, termfee = fees[0], fees[1], fees[2], fees[3]
    # print(records)
    for record in records:
        # print(record)
        time, carnum, inorout = record.split(" ")
        if costs.get(carnum, 0) == 0:
            costs[carnum] = 0
        # print(time, carnum, inorout)
        if inorout == "IN":  # 들어오는차
            parking[carnum] = time
        else:  # 나가는차
            intime = parking.get(carnum)
            parkingtime = returnDiffTime(time, intime)
            # print(time, intime, parkingtime)
            del parking[carnum]
            costs[carnum] += parkingtime

    remains = list(parking.keys())
    for remain in remains:
        unoutcar, unout_intime = remain, parking[remain]
        parkingtime = returnDiffTime('23:59', unout_intime)
        costs[unoutcar] += parkingtime

    # print(costs)
    tmpans = []
    for key, val in costs.items():
        if savetime >= val:  # 시간을 넘지 않았음
            tmpans.append([key, savefee])
        else:  # 시간을 넘었음
            fee1 = math.ceil((val - savetime) / termtime)
            fee2 = fee1 * termfee
            overfee = savefee + fee2
            tmpans.append([key, overfee])

    tmpans.sort(key=lambda x: x[0])
    answer = []
    for i in tmpans:
        answer.append(i[1])

    return answer


def returnDiffTime(outtime, intime):
    diff = datetime.strptime(outtime, '%H:%M') - \
        datetime.strptime(intime, '%H:%M')
    h, m, s = map(int, str(diff).split(":"))
    return h * 60 + m

# 배운 점:
# 1. string으로 된 시간형태끼리 차이 구하기 (datetime사용했음)
# 2. 올림하는법 (math.ceil)

# 별로 어렵진 않으나 푸는데 상당히 오래걸렸음. 연습이 더 필요
