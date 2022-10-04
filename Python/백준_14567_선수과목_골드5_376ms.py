import sys
from collections import defaultdict, deque
input = sys.stdin.readline

N, M = map(int, input().split())
# graph = [[] for i in range(N+1)]
graph = defaultdict(list)
indegree = [0 for i in range(N+1)]
result = [1 for i in range(N+1)]

for i in range(M):
    a, b = map(int, input().split())
    # 방향그래프 그리고 진입차수 세기
    graph[a].append(b)
    indegree[b] += 1

queue = deque()
for i in range(1, N+1):
    if indegree[i] == 0:
        queue.append((i, 1))  # 정점 번호, count

while queue:
    now, count = queue.popleft()
    for i in graph[now]:
        indegree[i] -= 1
        if indegree[i] == 0:
            queue.append((i, count+1))
            result[i] = count + 1

print(" ".join(map(str, result[1:])))

# 위상정렬. 거기에 dp적인 요소를 첨가함.
# 2차원 배열 graph 말고 collections 의 defaultdict 을 사용하면 좀 더 편리 (그러나 시간은 더 늘어나더라)
