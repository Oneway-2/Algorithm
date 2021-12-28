import sys
drc = [[-1,0],[1,0],[0,-1],[0,1]]
TC = int(input())
for testCase in range(TC):
  cnt = 0
  M, N, K = map(int, sys.stdin.readline().split())
  arr = [[0 for i in range(M)] for j in range(N)]
  visited = [[False for i in range(M)] for j in range(N)]
  for i in range(K):
    m, n = map(int, sys.stdin.readline().split())
    arr[n][m] = 1
  
  for r in range(N):
    for c in range(M):
      if arr[r][c] == 1 and visited[r][c] == False:
        cnt += 1
        queue = [(r, c)]
        while(len(queue) != 0) :
          rr, cc = queue.pop()
          for dr, dc in drc:
            nr = rr + dr
            nc = cc + dc
            if 0>nr or nr>=N or 0>nc or nc>= M or arr[nr][nc] == 0 or visited[nr][nc] == True:
              continue
            queue.append((nr, nc))
            visited[nr][nc] = True
  print(cnt)