import sys
import itertools
input = sys.stdin.readline
a, b = map(int, input().split())
arr = map(str, range(1, a+1))
print("\n".join(map(' '.join, itertools.permutations(arr, b))))
