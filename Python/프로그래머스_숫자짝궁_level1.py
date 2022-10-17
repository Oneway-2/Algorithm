def solution(X, Y):
    answer = []
    xdict = dict()
    ydict = dict()

    for x in X:
        xdict[x] = xdict.get(x, 0) + 1
    for y in Y:
        ydict[y] = ydict.get(y, 0) + 1

    for key, value in xdict.items():
        if key in ydict.keys():
            while ydict[key] > 0 and xdict[key] > 0:
                answer.append(key)
                ydict[key] = ydict.get(key)-1
                xdict[key] = xdict.get(key)-1

    if len(answer) == 0:
        return "-1"
    elif answer.count("0") == len(answer):
        return "0"

    answer.sort(reverse=True)
    return ''.join(answer)

# dict의 작동속도가 훨~씬 빠르다는걸 깨우친 사례다.

# # 11, 12, 13, 14, 15 시간초과난 코드
# def solution(X, Y):
#     xlist, ylist = [0]*10, [0]*10

#     for i in range(10):
#         si = str(i)
#         xlist[i] = X.count(si)
#         ylist[i] = Y.count(si)

#     answer = ''
#     idx = 9
#     # while True:
#     for idx in range(9, -1, -1):
#         if xlist[idx] > 0 and ylist[idx] > 0:
#             mini = min(xlist[idx], ylist[idx])
#             for i in range(mini):
#                 answer += str(idx)

#     if answer == '':
#         answer = '-1'
#     elif int(answer) == 0:
#         answer = '0'

#     return answer
