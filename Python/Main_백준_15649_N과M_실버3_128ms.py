# import itertools
# a, b = map(int, input().split())
# arr = list(range(1,a+1))
# npr = itertools.permutations(arr,b)
# for idx in npr:
#   for pr in idx:
#     print(pr, end=" ")
#   print()
  
import itertools
import sys
a, b = map(int, sys.stdin.readline().strip().split())
numbers = map(str, range(1, a+1))
print('\n'.join(map(' '.join, itertools.permutations(numbers, b))))
