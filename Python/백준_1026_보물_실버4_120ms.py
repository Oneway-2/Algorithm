import sys
input = sys.stdin.readline

N = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
a.sort()
minVal = 0
for i in range(N):
    minVal += a[i] * b.pop(b.index(max(b)))
print(minVal)