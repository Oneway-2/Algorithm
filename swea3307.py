# 최장 증가 부분 수열
import sys
TC = int(input())
for i in range(TC):
    n = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))
    sum_arr = []
    for j in range(1, len(arr) + 1):
        once = j + arr[j-1]
        sum_arr.append(once + arr[j-1])
    
    print(sum_arr)