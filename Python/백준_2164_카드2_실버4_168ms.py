import sys
from collections import deque
input = sys.stdin.readline
N = int(input())
nlist = deque(list(range(1, N+1)))
while(len(nlist) > 1):
    nlist.popleft()
    nlist.append(nlist.popleft())
print(nlist[0])
