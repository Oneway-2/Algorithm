import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split(" "))
indegree = [0 for i in range(N+1)]
graph = [[] for i in range(N+1)]
result = []

for i in range(M):
    a, b = map(int, input().split(" "))
    # 방향있는 간선으로 엮어주고 진입차수 증가
    graph[a].append(b)
    indegree[b] += 1

# 0 인 녀석부터 큐에 담고 시작
queue = deque()
for i in range(1, N+1):
    if indegree[i] == 0:
        queue.append(i)

# 큐가 끝날때까지 반복
while queue:
    # 현재 녀석을 빼고 result에 담은 뒤 엮인 녀석들이랑 간선 없애면서 바뀐 진입차수가 0이면 다시 큐에 담기
    now = queue.popleft()
    result.append(now)
    for i in graph[now]:
        indegree[i] -= 1
        if indegree[i] == 0:
            queue.append(i)

for i in result:
    print(i, end=" ")

# 위상정렬 문제 복습
