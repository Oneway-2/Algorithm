import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())
map = [[] for i in range(N)]
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
queue = deque()

for i in range(N):
    s = input().strip()
    for j in s:
        map[i].append(j)

queue.append([0, 0])
while queue:
    r, c = queue.popleft()
    for i in range(4):
        nr = dr[i] + r
        nc = dc[i] + c
        if 0 <= nr < N and 0 <= nc < M and map[nr][nc] == 1:
            map[nr][nc] = map[r][c] + 1
            queue.append([nr, nc])
