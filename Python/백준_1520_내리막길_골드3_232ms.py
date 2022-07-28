import sys
input = sys.stdin.readline
R, C = map(int, input().split())
graph = []
dp = [[-1 for i in range(C)] for j in range(R)]
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
for i in range(R):
    graph.append(list(map(int, input().split())))


def dfs(r, c):
    # 목적지에 도달했으면
    if r == R-1 and c == C-1:
        return 1

    # 이미 방문한 적이 있으면
    if dp[r][c] != -1:
        return dp[r][c]

    # 처음방문
    dp[r][c] = 0
    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0 <= nr < R and 0 <= nc < C and graph[r][c] > graph[nr][nc]:
            dp[r][c] += dfs(nr, nc)

    # 끝내 목적지에 도달하지 못함
    return dp[r][c]


print(dfs(0, 0))

# dp 의 힘은 대단하다..
