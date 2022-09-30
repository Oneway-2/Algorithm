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

queue = deque()
for i in range(N):
    course = []
    visited = [False for i in range(N)]
    queue.append(i)
    while queue:
        now = queue.popleft()
        for all in mmap[now]:
            if visited[all] == False:
                queue.append(all)
                visited[all] = True
                course.append(all)
    # print("i = {} , visit = {}".format(i, course))
    for a in course:
        answer[i][a] = 1

for i in answer:
    for j in i:
        print(j, end=" ")
    print()
