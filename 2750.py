# sorting numbers 

import sys
n = int(input())
nlist = []
for i in range(n):
    num = int(sys.stdin.readline().rstrip())
    nlist.append(num)
nlist.sort()
for i in nlist:
    print(i)

# int형변환 안시켜도 알아서 정렬되길래 맞는 줄 알았는데 꼭 int형변환 시켜줘야함.