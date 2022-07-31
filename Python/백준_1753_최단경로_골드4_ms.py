import sys
input = sys.stdin.readline
V, E = map(int, input().split())
R = int(input())
inf = sys.maxsize
graph = [[] for i in range(V+1)]
visited = [False for i in range(V+1)]
distance = [inf for i in range(V+1)]
end = V-1

for i in range(E):
    u, v, w = map(int, input().split())
    graph[u].append([v, w])
    graph[w].append([u, w])

cur = 0

for i in range(1, V+1):
    min = inf
    for j in range(1, V+1):
        if visited[j] == False and distance[j] < min:
            min = distance[j]
            cur = j
            print(distance[cur])

    visited[cur] = True
    if cur == end:
        print("INF")
        break
