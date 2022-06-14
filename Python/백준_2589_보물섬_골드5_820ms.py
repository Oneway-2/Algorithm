import sys
from collections import deque
input = sys.stdin.readline
R, C = map(int, input().split())
visited = [[False for i in range(C)] for i in range(R)]
result = 0
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
mmap = [list(input()) for i in range(R)]


def bfs():
    while queue:
        r, c, time = queue.popleft()
        global result
        result = max(time, result)
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 > nr or nr >= R or 0 > nc or nc >= C or mmap[nr][nc] == "W" or tvisited[nr][nc] == True:
                continue
            queue.append((nr, nc, time+1))
            tvisited[nr][nc] = True


for r in range(R):
    for c in range(C):
        if mmap[r][c] == "L":
            queue = deque()
            queue.append((r, c, 0))
            tvisited = [m[:] for m in visited]
            tvisited[r][c] = True
            bfs()

print(result)
