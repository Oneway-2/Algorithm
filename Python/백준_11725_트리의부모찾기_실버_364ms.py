from re import L
import sys
from collections import deque
input = sys.stdin.readline
N = int(input())
graph = [[] for i in range(N+1)]
visited = [False for i in range(N+1)]
answer = [0 for i in range(N+1)]
for i in range(N-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

queue = deque()
queue.append(1)
visited[1] = True
while queue:
    num = queue.popleft()
    for idx in graph[num]:
        if visited[idx] == False:
            visited[idx] = True
            answer[idx] = num
            queue.append(idx)

for i in answer[2:]:
    print(i)
