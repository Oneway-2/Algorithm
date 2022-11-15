import sys
input = sys.stdin.readline

N, K = map(int, input().split(" "))
DP = [[0 for i in range(K+1)] for i in range(N+1)]
graph = [[0, 0] for i in range(N+1)]
for i in range(1, N+1):
    graph[i][0], graph[i][1] = map(int, input().split(" "))

# N은 100까지, K는 100,000까지, 총 10,000,000(1초) 필요
for n in range(1, N+1):
    for k in range(1, K+1):
        weight, value = graph[n][0], graph[n][1]
        # 탐색하려는 무게에 못미친경우 이전 무게를 그대로 가져옴
        if k < weight:
            DP[n][k] = DP[n-1][k]
        # 무게 범위 내일 경우
        else:
            # 이전 무게랑 지금 내 무게 합친거랑, 현재 무게 중 더 큰거로 저장함
            DP[n][k] = max(DP[n-1][k-weight]+value, DP[n-1][k])

print(DP[N][K])

# import sys
# input = sys.stdin.readline

# N, K = map(int, input().split(" "))
# graph = [[0, 0] for i in range(N)]
# for i in range(N):
#     graph[i][0], graph[i][1] = map(int, input().split(" "))

# answer = 0
# idx = 0


# def getMaxVal(idx, accw, accv):
#     if accw > K:
#         return

#     global answer
#     if idx == N:
#         answer = accv if answer < accv else answer
#         return

#     w, v = graph[idx][0], graph[idx][1]

#     getMaxVal(idx+1, accw+w, accv+v)
#     getMaxVal(idx+1, accw, accv)


# for i in range(N):
#     getMaxVal(i, 0, 0)  # idx, accweight, accval
# print(answer)

# 백트랙킹 했다가 시간초과 남.
