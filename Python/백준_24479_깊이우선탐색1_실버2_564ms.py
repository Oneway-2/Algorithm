import sys
from collections import deque
input = sys.stdin.readline
N, M, R = map(int, input().split())
# graph = [[False for i in range(N+1)] for i in range(N+1)]
graph = [[] for i in range(N+1)]
visited = [False for i in range(N+1)]
answer = [0 for i in range(N+1)]

for i in range(M):
    a, b = map(int, input().split())
    # graph[a][b] = graph[b][a] = True
    graph[a].append(b)
    graph[b].append(a)

for i in range(N+1):
    # graph[i].sort()
    graph[i].sort(reverse=True)

# print(graph)
cnt = 1


# def dfs(num):
#     visited[num] = True
#     global cnt
#     # answer[cnt] = num
#     if answer[num] == 0:
#         answer[num] = cnt
#         cnt += 1
#     for idx in range(len(graph[num])):
#         s = graph[num][idx]
#         # 간선으로 연결되어있고 이미 방문하지 않았다면
#         # if graph[num][idx] == True and visited[idx] == False:
#         if visited[s] == False:
#             dfs(s)


# dfs(R)

stack = deque()
stack.append(R)

while stack:
    num = stack.pop()
    visited[num] = True
    if answer[num] == 0:
        answer[num] = cnt
        cnt += 1

    for idx in graph[num]:
        if visited[idx] == False:
            stack.append(idx)


for i in range(1, N+1):
    print(answer[i])

# 1. 전체를 리스트로 담다보니 메모리 초과남
# 2. 재귀를 쓰려다보니 간선이 200000개가 최대라 recursion error 뜸
# 3. 스택쓰고 while 쓴다.
