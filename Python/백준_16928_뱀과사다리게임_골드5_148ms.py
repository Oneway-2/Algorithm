import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
visited = [False for i in range(101)]
ladders = dict()
snakes = dict()
for i in range(N):
    a, b = map(int, input().split())
    ladders[a] = b
for i in range(M):
    a, b = map(int, input().split())
    snakes[a] = b

queue = deque()
queue.append((1, 0))  # num, cnt
visited[1] = True
while queue:
    cur = queue.popleft()
    num = cur[0]
    cnt = cur[1]
    if num == 100:
        print(cnt)
        break

    for i in range(1, 7):
        nextNum = num + i
        if nextNum > 100:  # 보드를 넘어가면 무효
            continue
        if nextNum in ladders.keys():  # 사다리 출발에 닿았으면
            nextNum = ladders[nextNum]  # 도착지점은 사다리의 끝
        if nextNum in snakes.keys():  # 뱀에 닿았으면
            nextNum = snakes[nextNum]  # 뱀따라 감
        if visited[nextNum] == False:  # 방문하지 않았으면 다음으로 이동을 허락
            queue.append((nextNum, cnt+1))
            visited[nextNum] = True
