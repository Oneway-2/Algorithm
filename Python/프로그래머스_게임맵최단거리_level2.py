from collections import deque


def solution(maps):
    sero = len(maps)
    garo = len(maps[0])
    visited = [[False for i in range(garo)] for i in range(sero)]
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    queue = deque()
    queue.append((0, 0, 1))  # r, c, step
    visited[0][0] = True
    answer = -1
    while queue:
        r, c, step = queue.popleft()
        if r == sero-1 and c == garo-1:
            answer = step
            break
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < sero and 0 <= nc < garo and maps[nr][nc] == 1 and visited[nr][nc] == False:
                queue.append((nr, nc, step+1))
                visited[nr][nc] = True

    return answer
