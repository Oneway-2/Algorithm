import sys
input = sys.stdin.readline
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
order = [0] * N
visited = [False] * N
result = 987654321

def perm(cnt):
  if cnt == N:
    play()
    return

  for i in range(N):
    if visited[i]:
      continue
    order[cnt] = i
    visited[i] = True
    perm(cnt + 1)
    visited[i] = False

def play():
  global result
  _from = 0
  _to = 0
  sum = 0
  for i in range(N-1):
    _from = order[i]
    _to = order[i+1]
    if arr[_from][_to] == 0:
      return
    sum += arr[_from][_to]

  _from = order[len(order) - 1]
  _to = order[0]
  if arr[_from][_to] == 0:
    return
  sum += arr[_from][_to]
  result = min(result, sum)

perm(0)
print(result)