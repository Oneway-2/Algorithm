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
for i in range(N):
    graph[i].sort()
stack = deque()
stack.append(R)
answer[R] = 1
cnt = 2
while stack:
    num = stack.pop()
    if answer[num] == 0:
        answer[num] = cnt
        cnt += 1
    for i in graph[num]:
        if answer[i] == 0:  # 방문한적 없으면
            stack.append(i)

for i in answer[1:]:
    print(i)
