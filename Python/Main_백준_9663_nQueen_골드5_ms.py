N = int(input())
cnt = 0
col = [0 for _ in range(N+1)]

def setQueens(garo):
  if(not(canPut-1)):
    return
  if(garo > N):
    cnt += 1
    return
  for i in range(1, N+1):
    col[garo] = i
    setQueens(garo + 1)

def canPut(garo):
  for sero in range(1, garo):
    if(col[garo] == col[sero] or abs(col[garo] - col[sero] == (garo - sero))):
      return False
    return True  
  
setQueens(1)
print(cnt)