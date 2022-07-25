import sys
from collections import deque

input = sys.stdin.readline
dr = [-2, -1, 1, 2, 2, 1, -1, -2]
dc = [1,  2, 2, 1, -1, -2, -2, -1]

TC = int(input())
for testCase in range(TC):
    startr = startc = endr = endc = 0
    R = int(input())

    visited = [[False for _ in range(R)] for _ in range(R)]
    startr, startc = map(int, input().split())
    endr, endc = map(int, input().split())
    queue = deque()
    queue.append([startr, startc, 0])
    visited[startr][startc] = True

    while queue:
        cur = queue.popleft()
        r, c, step = cur[0], cur[1], cur[2]
        # print("step = {}, r = {}, c = {}".format(step, r, c))
        if r == endr and c == endc:
            print(step)
            break
        for i in range(8):
            nr = r + dr[i]
            nc = c + dc[i]
            # 범위 내이고 방문한적 없으면
            if 0 <= nr < R and 0 <= nc < R and visited[nr][nc] == False:
                queue.append([nr, nc, step+1])
                visited[nr][nc] = True
