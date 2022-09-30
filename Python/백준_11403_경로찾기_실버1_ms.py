import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
mmap = [[] for i in range(N)]
answer = [[0 for i in range(N)] for i in range(N)]

for i in range(N):
    s = list(map(int, input().split(" ")))
    for j in range(len(s)):
        if s[j] == 1:
            mmap[i].append(j)

for i in mmap:
    for j in i:
        print(j, end=" ")
    print()

queue = deque()
for i in range(N):
    visit = []
    queue.append(i)
    while queue:
        now = queue.popleft()
        visit.append(now)
        for all in mmap[now]:
            queue.append(all)
    print("i = {} , visit = {}".format(i, visit))
