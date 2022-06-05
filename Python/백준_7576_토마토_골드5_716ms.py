import sys
from collections import deque
input = sys.stdin.readline

m, n = map(int, input().split())
nmap = [list(map(int, input().split())) for _ in range(n)]

queue = deque([])
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
result = 0

for i in range(n):
    for j in range(m):
        if nmap[i][j] == 1:
            queue.append([i, j])

def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = dx[i] + x, dy[i] + y
            if 0 <= nx < n and 0 <= ny < m and nmap[nx][ny] == 0:
                nmap[nx][ny] = nmap[x][y] + 1
                queue.append([nx, ny])

bfs()
for i in nmap:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    result = max(result, max(i))
print(result - 1)