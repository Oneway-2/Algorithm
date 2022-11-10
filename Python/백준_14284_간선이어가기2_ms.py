import sys
import heapq
input = sys.stdin.readline

N, M = map(int, input().split(" "))
graph = [[] for i in range(N+1)]
INF = sys.maxsize
distance = [[INF for i in range(N+1)] for i in range(N+1)]
for i in range(M):
    a, b, val = map(int, input().split(" "))
    graph[a].append((b, val))
    graph[b].append((a, val))
finalA, finalB = map(int, input().split(" "))

heap = []
for i in graph[finalA]:
    to, val = i[0], i[1]
    heapq.heappush(heap, (to, val))
    distance[finalA][to] = val

    while heap:
        fr, frval = heapq.heappop(heap)
        # print("fr = {}, frval = {}".format(fr, frval))
        for j in graph[fr]:
            frto, frtoval = j[0], j[1]
            print("frto = {}, frtoval = {}".format(frto, frtoval))
            heapq.heappush()
