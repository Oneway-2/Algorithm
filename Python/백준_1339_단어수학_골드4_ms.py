import sys
import itertools
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
print(alist)

nlist = map(list, itertools.combinations(one_ten, len(alist)))

result = 0
for i in nlist:
    sum = 0
    print(i)
    for j in alpa:
        tmp = []
        for k in j:
            # print(k, end=" ")
            # tmp.append(k)
            tmp.append(str(i[alist.index(k)]))
        con = ''.join(tmp)
        print("con = ", con)
        sum += int(con)
    result = max(result, sum)
    print("result = ", result)
print(result)
