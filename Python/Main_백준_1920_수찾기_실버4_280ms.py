N = int(input())
arr = list(map(int, input().split()))
M = int(input())
find = list(map(int, input().split()))
arr.sort()
for i in range(M):
  key = find[i]
  start = 0
  end = N - 1
  flag = False
  while end - start >= 0:
    mid = int((start + end) / 2)
    if (arr[mid] == key):
      print(1)
      flag = True
      break
    elif arr[mid] > key:
      end = mid - 1
    else:
      start = mid + 1
  if flag == False:
    print(0)
