import sys
import heapq
input = sys.stdin.readline
V, E = map(int, input().split())
R = int(input())
inf = sys.maxsize
graph = [[] for i in range(V+1)]
heap = []
distance = [inf for i in range(V+1)]

for i in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((w, v))


def dijkstra(start):
    # 가중치 테이블에서 시작 정점에 해당하는 가중치는 0으로 초기화
    distance[start] = 0
    heapq.heappush(heap, (0, start))

    while heap:
        weight, cur = heapq.heappop(heap)

        # 더 가중치가 큰건 볼 필요 없다.
        if distance[cur] < weight:
            continue

        for w, next in graph[cur]:
            nextWeight = w + weight
            # 만약 다음 노드까지의 가중치가 지금 기록된 값보다 작으면 더 빨리 갈 수 있는거. 갱신 ㄱㄱ
            if nextWeight < distance[next]:
                distance[next] = nextWeight
                heapq.heappush(heap, (nextWeight, next))


# R 부터 시작임
dijkstra(R)
for i in range(1, V+1):
    print("INF" if distance[i] == inf else distance[i])

# 참고 https://sungmin-joo.tistory.com/33
