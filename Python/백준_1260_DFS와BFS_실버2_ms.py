import sys
from collections import deque
input = sys.stdin.readline

N, M, V = map(int, input().split(" "))
graph = [[] for i in range(N+1)]

for i in range(M):
    a, b = map(int, input().split(" "))
    graph[a].append(b)
    graph[b].append(a)

# 정점번호가 작은거부터 해야함
for i in range(N+1):
    graph[i].sort()

# 재귀를 이용한 DFS
visitedd1 = [False for i in range(N+1)]
visitedd1[V] = True
def dfs_recur(v):
    print(v, end = " ")

    for i in graph[v]:
        if visitedd1[i] == False:
            visitedd1[i] = True
            dfs_recur(i)

# 재귀를 이용한 BFS
queue1 = deque()
visitedb1 = [False for i in range(N+1)]
queue1.append(V)
visitedb1[V] = True
def bfs_recur():
    if len(queue1) == 0:
        return

    now = queue1.popleft()
    print(now, end = " ")

    for i in graph[now]:
        if visitedb1[i] == False:
            queue1.append(i)
            visitedb1[i] = True
    bfs_recur()

# Stack을 이용한 DFS
stack = []
visitedd = [False for i in range(N+1)]
stack.append(V)
while stack:
    now = stack[-1]
    if visitedd[now] == False:
        print(now, end = " ")
        visitedd[now] = True
    end = True
    for i in graph[now]:
        if visitedd[i] == False:
            stack.append(i)
            end = False
            break
    if end == True:
        stack.pop()

print()
# Queue를 이용한 BFS
queue = deque()
visitedb = [False for i in range(N+1)]
queue.append(V)
visitedb[V] = True
while queue:
    now = queue.popleft()
    print(now, end = " ")
    for i in graph[now]:
        if visitedb[i] == False:
            queue.append(i)
            visitedb[i] = True


# dfs_recur(V)
# print()
# bfs_recur()

# BFS와 DFS를 각각 Queue 와 Stack 을 통해 구현하고 그리고 각각 재귀를 통해 구현해보았는데
# 결론은 BFS는 그냥 Queue와 While문을 써서 구현하고
# DFS는 재귀를 쓰는게 정신건강에 옳은 것 같다.