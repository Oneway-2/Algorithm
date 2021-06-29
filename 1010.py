# 다리놓기

import sys
import math
t = int(input())
for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    case = int(math.factorial(m) / (math.factorial(m-n) * math.factorial(n)))
    print(case)