import sys
from collections import deque

input = sys.stdin.readline
N, K = map(int, input().split())

visited = [False] * 100001  # 0 ~ 100000
queue = deque()
queue.append((N, 0))  # position, time
visited[N] = True

while queue:
    pos, time = queue.popleft()
    if pos == K:
        print(time)
        break

    for i, npos in enumerate([pos*2, pos-1, pos+1]):
        if 0 <= npos <= 100000 and visited[npos] == False:
            if i == 0:
                queue.append((npos, time))
            else:
                queue.append((npos, time+1))
            visited[npos] = True
