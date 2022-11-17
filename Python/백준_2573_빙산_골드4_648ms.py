import sys
from collections import deque
input = sys.stdin.readline
R, C = map(int, input().split(" "))

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
graph = []
for i in range(R):
    graph.append(list(map(int, input().split(" "))))

answer = 0
queue = deque()
while True:
    visited = [[False for i in range(C)] for i in range(R)]
    islandCnt = 0
    rlist = []
    for r in range(1, R):
        for c in range(1, C):
            if graph[r][c] != 0 and visited[r][c] == False:
                visited[r][c] = True
                queue.append((r, c))
                islandCnt += 1
                while queue:
                    rr, cc = queue.popleft()
                    zeroCnt = 0
                    for i in range(4):
                        nr = rr + dr[i]
                        nc = cc + dc[i]
                        if graph[nr][nc] == 0:
                            zeroCnt += 1
                        if graph[nr][nc] != 0 and visited[nr][nc] == False:
                            queue.append((nr, nc))
                            visited[nr][nc] = True
                    rlist.append((rr, cc, zeroCnt))

    # 만약 빙하 개수가 2개 이상이다?
    if islandCnt >= 2:
        print(answer)
        break

    # 만약 빙하가 다 녹아서 사라졌는데 빙하 개수가 2개를 넘은적이 없다?
    if len(rlist) == 0:
        print(0)
        break

    # 빙하 녹이기
    for rval in rlist:
        r, c, cnt = rval[0], rval[1], rval[2]
        graph[r][c] -= cnt
        if graph[r][c] < 0:
            graph[r][c] = 0

    answer += 1
