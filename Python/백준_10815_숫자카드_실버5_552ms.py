import sys
input = sys.stdin.readline

N = int(input())
cards = set(map(int, input().split(" ")))

M = int(input())
haveit = list(map(int, input().split(" ")))
for i in haveit:
    if i in cards:
        print(1, end=" ")
    else:
        print(0, end=" ")

# 중복을 허용하지 않는 set의 특성을 활용한 문제
