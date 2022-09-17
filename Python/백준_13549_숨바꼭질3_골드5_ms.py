import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())
visited = [False] * 100001  # 0 ~ 100000
queue = deque()
queue.append((N, 0))  # position, time

while queue:
    pos, time = queue.popleft()
    print(pos, time)
    for i in range(N+1, N-1):
        print(i)

    break
