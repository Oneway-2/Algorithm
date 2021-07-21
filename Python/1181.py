# 단어 정렬

import sys
t = int(input())
nlist = set()
for _ in range(t):
    nlist.add(sys.stdin.readline().rstrip())
nlist = list(nlist)
nlist.sort()
nlist.sort(key=len)
print('\n'.join(nlist))

# 해답보고 짜봄. 처음에 sort(key=len) 다음에 sort() 를 써서 틀린답이 나왔었는데, 그냥 두개 자리만 바꾸면 풀리는거였네
