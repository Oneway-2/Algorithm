import sys
input = sys.stdin.readline
N = int(input())
m = 2
while(N != 1):
    if N % m == 0:  # 나뉘어졌다
        print(m)
        N = N // m
        m = 2
    else:  # 안나뉘어졌다
        m += 1
