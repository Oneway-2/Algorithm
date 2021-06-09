# ACM Hotel

import sys
t = int(input())
for i in range (t):
    h, w, n = map(int, sys.stdin.readline().split())
    if n%h == 0:
        ho = n // h
        floor = h
        print("{}{:02d}".format(floor, ho))
    else:        
        ho = (n // h) + 1
        floor = n % h
        print("{}{:02d}".format(floor, ho))