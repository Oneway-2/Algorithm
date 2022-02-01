import sys
import itertools
a, b = map(int, sys.stdin.readline().strip().split())
arr = list(map(int, sys.stdin.readline().strip().split()))
arr.sort()
arr = map(str, arr)
result = map(' '.join, itertools.combinations_with_replacement(arr, b))
print('\n'.join(result))