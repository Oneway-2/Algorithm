import sys
import heapq
input = sys.stdin.readline

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

INF = sys.maxsize
TC = 1
while True:
    N = int(input())
    if N == 0:
        break
    graph = []
    distance = [[INF for i in range(N)] for i in range(N)]

    for n in range(N):
        s = list(map(int, input().split()))
        graph.append(s)

    heap = []
    heapq.heappush(heap, (0, 0, graph[0][0]))  # r, c, cost
    distance[0][0] = 0
    while heap:
        r, c, cost = heapq.heappop(heap)

        if r == N-1 and c == N-1:
            print("Problem {}: {}".format(TC, cost))
            TC += 1
            break

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < N and 0 <= nc < N:
                newCost = cost + graph[nr][nc]

                # 앞으로 가려는 곳의 누적 cost가 지금까지 distance에 저장된 cost보다 싸면 갱신
                if newCost < distance[nr][nc]:
                    distance[nr][nc] = newCost
                    heapq.heappush(heap, (nr, nc, newCost))

# 다익스트라, heap 사용
