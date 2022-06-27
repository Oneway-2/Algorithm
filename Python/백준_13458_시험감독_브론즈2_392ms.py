import sys
input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
B, C = map(int, input().split())
cnt = 0
for i in A:
    if i <= B:
        cnt += 1
    else:
        cnt += 1
        i -= B
        cnt += (i // C) + (0 if i % C == 0 else 1)
print(cnt)
