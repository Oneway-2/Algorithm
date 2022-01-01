def isAvailable(rowNo):
  for k in range(1, rowNo):
    if (col[rowNo] == col[k] or abs(col[rowNo] - col[k]) == (rowNo-k)):
      return False
  return True

def setQueen(rowNo):
  print("setQueen = ", rowNo)
  flag = isAvailable(rowNo-1)
  global cnt
  print("flag = ", flag, " cnt = ", cnt)
  if not(flag):
    return
  if rowNo > N:
    cnt += 1
    return
  for i in range(1, N+1):
    col[rowNo] = i
    setQueen(rowNo+1)

N = int(input())
col = [0 for i in range(N+1)]
cnt = 0
setQueen(1)

print(cnt)