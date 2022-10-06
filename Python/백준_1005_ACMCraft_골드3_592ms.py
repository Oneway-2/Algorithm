import sys
from collections import defaultdict, deque
input = sys.stdin.readline

TC = int(input())
for tc in range(TC):
    N, K = map(int, input().split(" "))
    indegree = [0 for i in range(N+1)]
    result = [0 for i in range(N+1)]
    # graph = defaultdict(list)
    graph = [[] for i in range(N+1)]
    time = [0]
    tmp = list(map(int, input().split(" ")))
    for i in tmp:
        time.append(i)

    for k in range(K):
        a, b = map(int, input().split(" "))
        graph[a].append(b)
        # 진입차수
        indegree[b] += 1

    queue = deque()
    for i in range(1, N+1):
        if indegree[i] == 0:
            queue.append((i, time[i]))  # idx num, time
            result[i] = time[i]

    while queue:
        now, nowtime = queue.popleft()
        for i in graph[now]:
            indegree[i] -= 1
            result[i] = nowtime + time[i] if nowtime + \
                time[i] >= result[i] else result[i]
            if indegree[i] == 0:
                # queue.append((i, nowtime + time[i]))
                queue.append((i, result[i]))

    answerNum = int(input())
    print(result[answerNum])

# 위상정렬 + DP
