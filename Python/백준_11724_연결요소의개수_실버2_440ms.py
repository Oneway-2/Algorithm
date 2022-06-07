import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())
_map = [[False for _ in range(N+1)] for _ in range(N+1)]
visited = [False for _ in range(N+1)]
cnt = 0

for i in range(M):
    x, y = map(int, input().split())
    _map[x][y] = _map[y][x] = True

queue = deque()
for e in range(1, N+1):
    if visited[e] == False:
        queue.append(e)
        visited[e] = True
    else:
        continue
    cnt += 1
    while queue:
        idx = queue.popleft()
        for i in range(1, N+1):
            if _map[i][idx] == True and visited[i] == False:
                visited[i] = True
                queue.append(i)

print(cnt)
