import sys
input = sys.stdin.readline
n, x = map(int, input().split())
# x 가 홀수면 에러
if x % 2 != 0:
    print("ERROR")
# n이 0보다 작으면 에러
elif n < 0:
    print("ERROR")
# x가 0이면 infinite
elif x == 0:
    print("INFINITE")
# 그 외엔 x의 개수 /2 한 만큼 줄어들면서, n이 0까지 도달할때까지 도는 for문 수 체크
else:
    interval = x // 2
    cnt = 0
    while n > 0:
        n -= interval
        cnt += 1
        # print("n : ", n)
    print(cnt-1)
