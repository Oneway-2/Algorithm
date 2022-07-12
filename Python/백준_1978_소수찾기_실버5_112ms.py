import sys
input = sys.stdin.readline
N = int(input())
numList = list(map(int, input().split()))
answerList = [True for i in range(1001)]  # 0 ~ 1000
answerList[0] = answerList[1] = False  # 0과 1은 소수

# 2부터 시작해서 그 배수들 싹다 거르기
for i in range(2, 101):
    mulIdx = 2
    mul = 1
    while(mul <= 1000):
        mul = i * mulIdx
        mulIdx += 1
        try:
            answerList[mul] = False
        except:
            break

cnt = 0
for i in numList:
    if answerList[i] == True:
        cnt += 1
print(cnt)
