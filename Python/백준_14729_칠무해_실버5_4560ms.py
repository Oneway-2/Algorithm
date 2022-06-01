import sys
input = sys.stdin.readline
nlist = []
N = int(input())
for _ in range(N):
    s = float(input())
    nlist.append(s)

nlist.sort()

for i in range(7):
    print("%.3f" % nlist[i])
