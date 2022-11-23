import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split(" "))  # 사람 수(1부터 시작) , 파티 수

graph = [[0 for i in range(N+1)] for i in range(N+1)]
know = list(map(int, input().split(" ")))[1:]
for k in know:
    for n in know:
        graph[k][n] = 2

queue = deque()
rememberParties = []
for m in range(M):
    partyMember = list(map(int, input().split(" ")))[1:]
    rememberParties.append(partyMember)
    isKnowHere = False
    for p in partyMember:
        if graph[p][p] == 2:
            isKnowHere = True
            break

    if isKnowHere == True:
        # BFS로 2로 싹 변경
        visited = [False for i in range(N+1)]
        for p in partyMember:
            queue.append(p)
            visited[p] = True
            while queue:
                cur = queue.popleft()
                for idx in range(1, N+1):
                    if graph[cur][idx] != 0:
                        graph[cur][idx] = 2
                        if visited[idx] == False:
                            queue.append(idx)
                            visited[idx] = True

        # 2중for로 2로 싹 연결
        for p in partyMember:
            for j in partyMember:
                graph[p][j] = 2

    else:
        # 2중for로 1로 싹 연결
        for p in partyMember:
            for j in partyMember:
                graph[p][j] = 1

answer = 0
for rem in rememberParties:
    canLie = True
    for r in rem:
        if graph[r][r] == 2:
            canLie = False
            break
    if canLie == True:
        answer += 1
print(answer)

# N이 50개라 인접행렬 방식을 사용.
# 진실을 아는 사람을 탐색할 때 BFS 사용
# 순서와 관계없이 진실을 아는 사람과 파티에 있었던 경우도 거짓말을 하지 못하는 것을 고려해야함.
# 아니 그러면 지민이는 몸이 1개인데 많은 파티에 동시에 참석한다는거야 뭐야
# 아무튼 그래서 모든 파티에 대해 진실을 아는 사람이 있었는지 확인하고, 진실을 아는 사람을 알아낸 뒤 다시 한 번 파티에 대입해서 answer 구함
