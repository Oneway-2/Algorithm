import sys
from collections import deque
input = sys.stdin.readline
R, C = map(int, input().split(" "))
visited = [[False for i in range(C)] for i in range(R)]
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
graph = [list(input()) for i in range(R)]
answer = 0

for rr in range(R):
    for cc in range(C):
        if graph[rr][cc] == "L":
            queue = deque()
            queue.append((rr, cc, 0))
            tvisited = [m[:] for m in visited]
            tvisited[rr][cc] = True

            while queue:
                r, c, time = queue.popleft()
                answer = max(time, answer)
                for i in range(4):
                    nr = r + dr[i]
                    nc = c + dc[i]
                    if 0 <= nr < R and 0 <= nc < C and graph[nr][nc] == "L" and tvisited[nr][nc] == False:
                        queue.append((nr, nc, time+1))
                        tvisited[nr][nc] = True
print(answer)
