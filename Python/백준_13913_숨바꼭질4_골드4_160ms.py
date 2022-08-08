import sys
from collections import deque
input = sys.stdin.readline
N, K = map(int, input().split())  # 시작, 끝
graph = [False] * 100001
path = [0] * 100001
queue = deque()
queue.append((N, 0))
graph[N] = True
while queue:
    cur = queue.popleft()
    pos, time = cur[0], cur[1]
    if pos == K:
        print(time)
        ans = []
        while pos != N:
            ans.append(pos)
            pos = path[pos]
        ans.append(N)
        ans.reverse()
        print(" ".join(map(str, ans)))
        break
    for npos in (pos-1, pos+1, 2*pos):
        if 0 > npos or npos > 100000 or graph[npos] == True:
            continue
        queue.append((npos, time+1))
        graph[npos] = True
        path[npos] = pos

# 5 / 4 6 10 / 3 8 / 7 12 / 9 11 20 / 2 / 16 / 14 / 13 24 / 18 / ... / 17

# path[4] = 5
# path[6] = 5
# path[10] = 5 *********

# path[3] = 4
# path[8] = 4

# path[7] = 6
# path[12] = 6

# path[9] = 10 *********
# path[11] = 10
# path[20] = 10

# path[2] = 3

# path[16] = 8

# path[14] = 7

# path[13] = 12
# path[24] = 12

# path[18] = 9 *********

# path[17] = 18 *********

# path[17] = 18 => path[18] = 9 => path[9] = 10 => path[10] = 5 end.
