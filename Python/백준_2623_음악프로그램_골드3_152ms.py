import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split(" "))
indegree = [0 for i in range(N)]
graph = [[] for i in range(N)]

for _ in range(M):
    mlist = list(map(int, input().split(" ")))
    for a, b in zip(mlist[1:], mlist[2:]):
        # 간선 그리고 진입차수 세기
        graph[a-1].append(b-1)
        indegree[b-1] += 1

result = []
queue = deque()
# 진입차수 0인거만 골라 넣기
for i in range(N):
    if indegree[i] == 0:
        queue.append(i)

# 큐가 빌 때 까지 반복
while queue:
    # 큐에서 원소를 꺼내 연결된 모든 간선을 제거한다. 제거하면서 진입차수가 변경되는데, 0으로 된 녀석은 다시 큐에 넣어줌.
    now = queue.popleft()
    result.append(now + 1)
    for i in graph[now]:
        indegree[i] -= 1
        if indegree[i] == 0:
            queue.append(i)

# 큐가 끝났는데 진입차수가 남아있다는건 모든 정점을 돌지 못했다는 것 == 결론을 낼 수가 없음
if sum(indegree) > 0:
    print(0)
else:
    for i in result:
        print(i)

# 1 4 3 이라 하면, 3으로 가기 위해 4을 거쳐야 하고, 4로 가기위해 1을 거쳐야 함.
# 6 2 5 4 도 마찬가지로 4로 가기 위해 5를, 5로 가기 위해 2를, 2를 가기 위해 6을 거쳐야 함.
# 이러한 규칙을 만족하는 순서를 만들자.
# => 위상정렬 알고리즘 사용하기

# 위상정렬
# 1. 진입차수 (들어오는 간선의 개수)가 0인 정점을 큐에 삽입한다.
# 2. 큐에서 원소를 꺼내 연결된 모든 간선을 제거한다. (이 때 꺼낸 순서를 result에 담음)
# 3. 간선 제거 이후 진입차수가 0이 된 정점을 큐에 삽입한다.
# 4. 큐가 빌 때 까지 2,3번 과정을 반복한다. 모든 원소를 방문하기 전에 큐가 빈다면 사이클이 존재하는 것이고, 모든 원소를 방문했다면 큐에서 꺼낸 순서가 위상 정렬의 결과이다.
# 위상정렬 정보 출처: https://www.youtube.com/watch?v=qzfeVeajuyc
