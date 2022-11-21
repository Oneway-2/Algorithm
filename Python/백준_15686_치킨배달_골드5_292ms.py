import sys
import itertools
input = sys.stdin.readline
N, M = map(int, input().split(" "))
graph = []
for i in range(N):
    graph.append(list(map(int, input().split(" "))))
home = []
chicken = []
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            home.append([i, j])
        if graph[i][j] == 2:
            chicken.append([i, j])

answer = sys.maxsize
# 1부터 탐색
for m in range(1, M+1):
    # 조합 이용 (중복 X)
    for chi in itertools.combinations(chicken, m):
        tmp = 0
        # 모든 집에 대해서 일단 탐색 후, 최솟값으로 갱신
        for h in home:
            chilen = sys.maxsize
            for i in range(m):
                chilen = min(chilen, abs(h[0]-chi[i][0]) + abs(h[1]-chi[i][1]))
            tmp += chilen
        answer = min(answer, tmp)

print(answer)

# 완전탐색, 조합
