import sys
from collections import deque
input = sys.stdin.readline

N, M, R = map(int, input().split())
graph = [[] for i in range(N+1)]
answer = [0 for i in range(N+1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in range(N+1):
    graph[i].sort(reverse=True)

queue = deque()
queue.append(R)
answer[R] = 1
cnt = 2
while queue:
    num = queue.popleft()

    for i in graph[num]:
        if answer[i] == 0:
            queue.append(i)
            answer[i] = cnt
            cnt += 1

for i in answer[1:]:
    print(i)
