import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())
graph = [[] for i in range(N+1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False for i in range(N+1)]
bacon = sys.maxsize
answer = 0


def doBacon(start):
    queue = deque()
    queue.append((start, 0))  # num, step
    visited[start] = True
    tmpBacon = 0
    while queue:
        cur = queue.popleft()
        num = cur[0]
        step = cur[1]
        tmpBacon += step
        for idx in graph[num]:
            if visited[idx] == False:  # 방문한 적이 없다면
                queue.append((idx, step+1))
                visited[idx] = True

    global answer, bacon
    if bacon > tmpBacon:
        bacon = tmpBacon
        answer = start


for i in range(1, N+1):
    for j in range(N+1):
        visited[j] = False
    doBacon(i)

print(answer)
