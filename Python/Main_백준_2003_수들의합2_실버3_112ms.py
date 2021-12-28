N, M = map(int, input().split())
arr = list(map(int, input().split()))
sum = a = b = cnt = 0
while(True):
  if sum >= M:
    sum -= arr[a]
    a += 1
  elif b == N:
    break
  else:
    sum += arr[b]
    b += 1
  if sum == M:
    cnt += 1
print(cnt)
