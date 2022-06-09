import sys
# import copy
# import time
from collections import deque
# start = time.time()
input = sys.stdin.readline
R, C = map(int, input().split())
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
mmap = []
answer = 0
for i in range(R):
    mmap.append(list(map(int, input().split())))


def bfs():
    queue = deque()
    tmap = [m[:] for m in mmap]
    # tmap = copy.deepcopy(mmap)
    for i in range(R):
        for j in range(C):
            if tmap[i][j] == 2:
                queue.append((i, j))

    while queue:
        r, c = queue.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 > nr or nr >= R or 0 > nc or nc >= C:
                continue
            if tmap[nr][nc] == 0:
                tmap[nr][nc] = 2
                queue.append((nr, nc))

    global answer
    cnt = 0
    for i in range(R):
        cnt += tmap[i].count(0)
    answer = max(answer, cnt)


def backtrack(cnt):
    if cnt == 3:
        bfs()
        return
    for i in range(R):
        for j in range(C):
            if mmap[i][j] == 0:
                mmap[i][j] = 1
                backtrack(cnt+1)
                mmap[i][j] = 0


backtrack(0)
print(answer)
# print("time : ", time.time() - start)
