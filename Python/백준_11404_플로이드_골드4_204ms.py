import sys

input = sys.stdin.readline
INF = sys.maxsize
N = int(input())  # 도시의 개수 2 ~ 100
M = int(input())  # 버스의 개수 1 ~ 100,000

graph = [[INF for i in range(N+1)] for i in range(N+1)]
for i in range(N+1):
    graph[i][i] = 0

# 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있음을 주의
for m in range(M):
    a, b, w = map(int, input().split())
    if graph[a][b] > w:
        graph[a][b] = w

for k in range(1, N+1):  # 거치는
    for i in range(1, N+1):  # 출발
        for j in range(1, N+1):  # 도착
            if graph[i][k] + graph[k][j] < graph[i][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

for i in graph[1:]:
    for j in i[1:]:
        # 갈 수 없는 경우 0을 출력한다는 조건을 조심
        if j == INF:
            print(0, end=" ")
        else:
            print(j, end=" ")
    print()

# 플로이드 워셜 알고리즘 => 어딘가를 거쳐서 갈 수 있는지를 구해라 or 어딘가부터 어디로 이동할 때 최소비용을 구해라
# graph를 잘 작성하고, k, i, j 만 기억하면 쉽다.
