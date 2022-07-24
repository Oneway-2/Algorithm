import sys
from collections import deque
input = sys.stdin.readline
N, M, R = map(int, input().split())
graph = [[] for i in range(N+1)]
# visited = [False for i in range(N+1)]
answer = [0 for i in range(N+1)]

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N+1):
    graph[i].sort()


queue = deque()
queue.append(R)
answer[R] = 1
cnt = 2
while queue:
    num = queue.popleft()
    # visited[num] = True
    # if answer[num] == 0:
    #     answer[num] = cnt
    #     cnt += 1

    for idx in graph[num]:
        if answer[idx] == 0:  # 방문한적 없으면 고
            queue.append(idx)
            answer[idx] = cnt
            cnt += 1

for i in answer[1:]:
    print(i)

# 왜 계속 시간초과뜨지 일단 세이브좀
# visited 이녀석 생성하는 시간이 오래걸렸나? visited 역할을 answer가 대신 하게 해줬더니 통과됐다.