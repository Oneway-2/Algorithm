import sys
from collections import deque
input = sys.stdin.readline

dh = [-1, 1, 0, 0, 0, 0]
dr = [0, 0, -1, 1, 0, 0]
dc = [0, 0, 0, 0, -1, 1]

while True:
    h, r, c = map(int, input().split(" "))
    if h == 0 and r == 0 and c == 0:
        break

    sh, sr, sc = -1, -1, -1
    eh, er, ec = -1, -1, -1

    graph = []
    for H in range(h):
        tgraph = []
        for R in range(r):
            tlist = list(map(str, input().rstrip()))

            for C in range(c):
                if tlist[C] == 'S':
                    sh, sr, sc = H, R, C
                elif tlist[C] == 'E':
                    eh, er, ec = H, R, C

            tgraph.append(tlist)
        graph.append(tgraph)
        input()

    queue = deque()
    visited = [[[False for _ in range(c)] for _ in range(r)] for _ in range(h)]
    queue.append((sh, sr, sc, 0))
    visited[sh][sr][sc] = True

    escapeTime = -1
    while queue:
        H, R, C, time = queue.popleft()

        if H == eh and R == er and C == ec:
            escapeTime = time
            break

        for i in range(6):
            nh = H + dh[i]
            nr = R + dr[i]
            nc = C + dc[i]

            if 0 <= nh < h and 0 <= nr < r and 0 <= nc < c and graph[nh][nr][nc] != '#' and visited[nh][nr][nc] == False:
                queue.append((nh, nr, nc, time+1))
                visited[nh][nr][nc] = True

    if escapeTime == -1:
        print("Trapped!")
    else:
        print("Escaped in {} minute(s).".format(escapeTime))
