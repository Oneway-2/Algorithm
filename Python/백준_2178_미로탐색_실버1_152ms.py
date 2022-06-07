import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())
map = [[] for i in range(N)]
visited = [[False for _ in range(M)] for _ in range(N)]
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
queue = deque()

for i in range(N):
    s = input().strip()
    for j in s:
        map[i].append(int(j))

queue.append([0, 0, 1])
visited[0][0] = True
while queue:
    r, c, step = queue.popleft()
    if r == N-1 and c == M-1:
        print(step)
        break
    for i in range(4):
        nr = dr[i] + r
        nc = dc[i] + c
        if 0 <= nr < N and 0 <= nc < M and map[nr][nc] == 1 and visited[nr][nc] == False:
            visited[nr][nc] = True
            queue.append([nr, nc, step+1])
