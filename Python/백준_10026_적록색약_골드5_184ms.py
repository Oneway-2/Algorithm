import sys
from collections import deque
input = sys.stdin.readline
N = int(input())
mmap = [[] for i in range(N)]
visited = [[False for i in range(N)] for i in range(N)]
for i in range(N):
    s = input().rstrip()
    for j in s:
        mmap[i].append(j)
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
queue = deque()

acnt = 0
ncnt = 0


def abfs():
    for i in range(N):
        for j in range(N):
            this = mmap[i][j]
            if visited[i][j] == False:
                queue.append((i, j))
                visited[i][j] = True
                global acnt
                acnt += 1
                while queue:
                    r, c = queue.popleft()
                    for k in range(4):
                        nr = r + dr[k]
                        nc = c + dc[k]
                        if 0 > nr or nr >= N or 0 > nc or nc >= N or visited[nr][nc] == True:
                            continue
                        if this == "R" or this == "G":
                            if mmap[nr][nc] == "R" or mmap[nr][nc] == "G":
                                queue.append((nr, nc))
                                visited[nr][nc] = True
                        else:
                            if mmap[nr][nc] == "B":
                                queue.append((nr, nc))
                                visited[nr][nc] = True


def nbfs():
    for i in range(N):
        for j in range(N):
            this = mmap[i][j]
            if visited[i][j] == False:
                queue.append((i, j))
                visited[i][j] = True
                global ncnt
                ncnt += 1
                while queue:
                    r, c = queue.popleft()
                    for k in range(4):
                        nr = r + dr[k]
                        nc = c + dc[k]
                        if 0 > nr or nr >= N or 0 > nc or nc >= N or visited[nr][nc] == True:
                            continue
                        if this == "R":
                            if mmap[nr][nc] == "R":
                                queue.append((nr, nc))
                                visited[nr][nc] = True
                        elif this == "G":
                            if mmap[nr][nc] == "G":
                                queue.append((nr, nc))
                                visited[nr][nc] = True
                        else:
                            if mmap[nr][nc] == "B":
                                queue.append((nr, nc))
                                visited[nr][nc] = True


abfs()
for i in range(N):
    for j in range(N):
        visited[i][j] = False
nbfs()

print(ncnt, acnt)
