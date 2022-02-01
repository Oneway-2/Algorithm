import sys
import itertools
a, b = map(int, sys.stdin.readline().strip().split())
arr = map(str, range(1, a+1))
print('\n'.join(map(' '.join, itertools.permutations(arr, b))))
