# 시간 초과 뜸.
# 답이 나오긴 하지만,, 순열을 쓰면 경우의 수가 너무 많다.

import sys
import itertools
import time
start = time.time()
input = sys.stdin.readline
N = int(input())
alpa = [[] for i in range(N)]
alist = set()
for idx in range(N):
    alpa[idx] = list(input().rstrip())
    for i in alpa[idx]:
        alist.add(i)

alist = list(alist)
one_ten = list(range(10))
nlist = map(list, itertools.permutations(one_ten, len(alist)))

result = 0
for i in nlist:
    sum = 0
    for j in alpa:
        tmp = []
        for k in j:
            tmp.append(str(i[alist.index(k)]))
        con = ''.join(tmp)
        sum += int(con)
    result = max(result, sum)
print("걸린 시간 : ", time.time()-start)
print(result)
