import sys
input = sys.stdin.readline
N, M = map(int, input().split(" "))
graph = [[] for i in range(N)]
for i in range(M):
    a, b = map(int, input().split(" "))
    graph[a].append(b)
    graph[b].append(a)

for i in range(N):
    graph[i].sort()

isEnd = False


def DFS(v, step, visited):
    # print("v = {}, step = {}, visited = {}".format(v, step, visited))
    global isEnd
    if isEnd == True:
        return
    if step >= 4:
        isEnd = True
        return

    for i in graph[v]:
        if visited[i] == False:
            visited[i] = True
            DFS(i, step+1, visited)
            visited[i] = False


for i in range(N):
    visited = [False for i in range(N)]
    visited[i] = True
    DFS(i, 0, visited)
    visited[i] = False
    if isEnd == True:
        break

print(0 if isEnd == False else 1)
