import sys
from collections import deque
input = sys.stdin.readline
R, C = map(int, input().split(" "))
graph = []
for i in range(R):
    s = input().rstrip()
    graph.append(list(s))

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

fqueue = deque()
jqueue = deque()

fcnt = 0
jcnt = 0
for r in range(R):
    for c in range(C):
        if graph[r][c] == 'F':
            fqueue.append((r, c))
            fcnt += 1
        if graph[r][c] == 'J':
            jqueue.append((r, c))
            jcnt += 1


time = 0
escaped = False
while True:
    time += 1
    # 불번짐 먼저 시작
    ftmp = 0
    for f in range(fcnt):
        r, c = fqueue.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < R and 0 <= nc < C:
                if graph[nr][nc] == 'J' or graph[nr][nc] == '.':
                    fqueue.append((nr, nc))
                    ftmp += 1
                    graph[nr][nc] = 'F'
    fcnt = ftmp

    # 지훈이 이동
    jtmp = 0
    died = True
    for j in range(jcnt):
        r, c = jqueue.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < R and 0 <= nc < C:
                if graph[nr][nc] == '.':
                    died = False
                    jqueue.append((nr, nc))
                    jtmp += 1
                    graph[nr][nc] = 'J'
            else:
                # 탈출 성공
                escaped = True
    jcnt = jtmp

    if escaped == True:
        print(time)
        break
    if died == True:
        print("IMPOSSIBLE")
        break

# 시뮬레이션과 BFS가 합쳐진 문제
# 반례를 찾느라 정말 많이 틀렸다..
