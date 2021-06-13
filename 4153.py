# 직각삼각형

import sys
while True:
    a, b, c = map(int, sys.stdin.readline().split())
    if a == 0 and b == 0 and c == 0:
        break
    if b < c:
        b, c = c, b
    if a < b:
        a, b = b, a    
    if a*a == b*b + c*c:
        print("right")
    else:
        print("wrong")