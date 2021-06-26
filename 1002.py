# 1002 turret

import math
import sys

t = int(input())
for _ in range(t):
    x1, y1, r1, x2, y2, r2 = map(int, sys.stdin.readline().split())
    d = math.sqrt(pow(abs(x2-x1), 2) + pow(abs(y2-y1),2))
    # print("d == {} , r1+r2 == {}, abs(r1-r2) == {}".format(d, r1+r2, abs(r1-r2)))
    if x1 == x2 and y1 == y2 and r1 == r2:
        print(-1)        
    elif x1 == x2 and y1 == y2 and r1 != r2:
        print(0)        
    elif d < abs(r1 - r2):
        print(0)        
    elif d > r1 + r2:
        print(0)
    elif d == abs(r1 - r2):
        print(1)        
    elif d == r1 + r2:
        print(1)        
    elif d > abs(r1 - r2):
        print(2)
    elif d < r1 + r2:
        print(2)