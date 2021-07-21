# 분산 처리

import sys
t = int(input())
for _ in range(t):
    a, b = map(int, sys.stdin.readline().split())
    aa = a % 10
    if aa == 0:
        print(10)
    elif aa == 1 or aa == 5 or aa == 6:
        print(aa)
    elif aa == 4:
        bb = b % 2
        if bb == 1:
            print(4)
        elif bb == 0:
            print(6)
    elif aa == 9:
        bb = b % 2
        if bb == 1:
            print(9)
        elif bb == 0:
            print(1)
    elif aa == 2:
        bb = b % 4
        if bb == 1:
            print(2)
        elif bb == 2:
            print(4)
        elif bb == 3:
            print(8)
        elif bb == 0:
            print(6)
    elif aa == 3:
        bb = b % 4
        if bb == 1:
            print(3)
        elif bb == 2:
            print(9)
        elif bb == 3:
            print(7)
        elif bb == 0:
            print(1)
    elif aa == 7:
        bb = b % 4
        if bb == 1:
            print(7)
        elif bb == 2:
            print(9)
        elif bb == 3:
            print(3)
        elif bb == 0:
            print(1)
    elif aa == 8:
        bb = b % 4
        if bb == 1:
            print(8)
        elif bb == 2:
            print(4)
        elif bb == 3:
            print(2)
        elif bb == 0:
            print(6)

# python의 pow 함수를 사용하면 훨씬 쉽고 빠르게 풀 수 있따..