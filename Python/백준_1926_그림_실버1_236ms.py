import sys
from collections import deque
input = sys.stdin.readline
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
R, C = map(int, input().split(" "))
graph = []
visited = [[False for i in range(C)] for i in range(R)]
for i in range(R):
    graph.append(list(map(int, input().split(" "))))

maxArea = 0
areaCnt = 0
queue = deque()
for r in range(R):
    for c in range(C):
        if graph[r][c] == 1 and visited[r][c] == False:
            queue.append((r, c))
            visited[r][c] = True
            areaCnt += 1
            areaSize = 0
            while queue:
                areaSize += 1
                rr, cc = queue.popleft()
                for i in range(4):
                    nr = rr + dr[i]
                    nc = cc + dc[i]
                    if 0 <= nr < R and 0 <= nc < C and visited[nr][nc] == False and graph[nr][nc] == 1:
                        queue.append((nr, nc))
                        visited[nr][nc] = True
            maxArea = areaSize if areaSize > maxArea else maxArea
print(areaCnt)
print(maxArea)
