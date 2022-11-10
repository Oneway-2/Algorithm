import sys
import heapq
input = sys.stdin.readline

N, M = map(int, input().split(" "))
graph = [[] for i in range(N+1)]
INF = sys.maxsize
distance = [INF for i in range(N+1)]
for i in range(M):
    a, b, val = map(int, input().split(" "))
    graph[a].append((b, val))
    graph[b].append((a, val))
finalA, finalB = map(int, input().split(" "))
distance[finalA] = 0

heap = []
for i in graph[finalA]:
    to, val = i[0], i[1]
    heapq.heappush(heap, (to, val))
    distance[to] = val

while heap:
    fr, val = heapq.heappop(heap)
    for j in graph[fr]:
        to, toval = j[0], j[1]
        newVal = val + toval
        if distance[to] > newVal:
            distance[to] = newVal
            heapq.heappush(heap, (to, newVal))

print(distance[finalB])

# 다익스트라
