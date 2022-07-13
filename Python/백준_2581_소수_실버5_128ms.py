import sys
input = sys.stdin.readline
M = int(input())
N = int(input())
answerList = [True for i in range(10001)]  # 0 ~ 10000
answerList[0] = answerList[1] = False  # 0과 1은 소수

# 2부터 시작해서 10000까지 소수 아닌거 거르기
for i in range(2, 10001):
    mulIdx = 2
    mul = 1
    # i 가 이미 소수가 아닌 녀석은 그 배수가 이미 제거되었음.
    if answerList[i] == False:
        # print("i == {} 는 이미 제거됐다.".format(i))
        continue
    while(mul <= 10000):
        mul = i * mulIdx
        mulIdx += 1
        # print("i == {}, mul = {}, mulIdx = {}".format(i, mul, mulIdx))
        try:
            answerList[mul] = False
        except:
            break

numList = []
for i in range(M, N+1):
    if answerList[i] == True:
        numList.append(i)

if len(numList) == 0:
    print(-1)
else:
    print(sum(numList))
    print(numList[0])
