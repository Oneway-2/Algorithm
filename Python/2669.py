# 직사각형 네 개의 합집합의 면적 구하기

import sys
nlist = [[0 for i in range(99)] for i in range(99)]

# def Show():
#     for i in range(len(nlist)):
#         print('')
#         for j in range(len(nlist[0])):
#             print(nlist[i][j],end="")

for j in range(4):
    x,y,xx,yy = map(int, sys.stdin.readline().split()) 
    xx = xx-x
    yy = yy-y 
    x = x-1 
    y = y-1 
    for b in range(y, y+yy):
        for a in range(x, x+xx):
            nlist[a][b] = 1
    # Show()

# sum = 0
# for i in range(len(nlist[0])):
#     sum += nlist[i].count(1)
# print(sum) 

total = 0
for i in nlist:
    total += sum(i)
print(total) 