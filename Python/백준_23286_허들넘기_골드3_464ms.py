import sys
input = sys.stdin.readline
N, M, T = map(int, input().split(" "))
INF = sys.maxsize
graph = [[INF for i in range(N+1)] for i in range(N+1)]
for i in range(M):
    a, b, val = map(int, input().split(" "))
    graph[a][b] = val
for k in range(1, N+1):
    for i in range(1, N+1):
        for j in range(1, N+1):
            bigger = graph[i][k] if graph[i][k] > graph[k][j] else graph[k][j]
            graph[i][j] = bigger if graph[i][j] > bigger else graph[i][j]

for tc in range(T):
    a, b = map(int, input().split(" "))
    if graph[a][b] != INF:
        print(graph[a][b])
    else:
        print(-1)

# import heapq
# input = sys.stdin.readline
# N, M, T = map(int, input().split(" "))
# graph = [[] for i in range(N+1)]
# for i in range(M):
#     a, b, val = map(int, input().split(" "))
#     graph[a].append((b, val))
# INF = sys.maxsize
# for tc in range(T):
#     start, end = map(int, input().split(" "))
#     distance = [INF for i in range(N+1)]
#     heap = []
#     heapq.heappush(heap, start)
#     distance[start] = 0
#     while heap:
#         fr = heapq.heappop(heap)
#         for g in graph[fr]:
#             to, toval = g[0], g[1]
#             biggerVal = distance[fr] if distance[fr] > toval else toval
#             if distance[to] > biggerVal:
#                 distance[to] = biggerVal
#                 heapq.heappush(heap, to)
#     print(distance[end] if distance[end] != INF else -1)

# 아 거쳐가는 노드의 최소값 구하는거라 다익스트라 쓰는 줄 알았는데
# T가 40000번 돌아야해서 매번 최소거리를 구하는게 비효율적임을 너무 늦게 깨우침.
# 한 번에 모든 노드->노드 로 가는 최소거리를 구하는 플로이드-워셜 알고리즘이 정답이었다.
