import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
mmap = [[] for i in range(N)]
for i in range(N):
    s = input().rstrip()
    for j in s:
        mmap[i].append(j)

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
visited = [[[0] * 2 for _ in range(M)] for _ in range(N)]


def bfs():
    q = deque()
    q.append([0, 0, 0])
    visited[0][0][0] = 1

    while q:
        r, c, w = q.popleft()

        if r == N-1 and c == M-1:
            return visited[r][c][w]

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            if 0 <= nr < N and 0 <= nc < M:
                # 다음 위치로 이동할 수 있고, 방문하지 않았다면
                if mmap[nr][nc] == '0' and visited[nr][nc][w] == 0:
                    visited[nr][nc][w] = visited[r][c][w] + 1
                    q.append([nr, nc, w])

                # 다음 위치가 벽이고, 벽을 아직 안부셨다면
                elif mmap[nr][nc] == '1' and w == 0:
                    visited[nr][nc][w+1] = visited[r][c][w] + 1
                    q.append([nr, nc, w+1])

    # 목표까지 도달하지 못했으면 -1 출력
    return -1


print(bfs())
