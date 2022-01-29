from tkinter.tix import INTEGER


M, N = map(int, input().split())
map = list(list(0 for _ in range(N)) for _ in range(M))

for i in range(M):
  s = input()
  for j in range(N):
    map[i][j] = s[j]

m = M-7
n = N-7
minCnt = 9876543210
cntw = 0
cntb = 0
for i in range(m):
  for j in range(n):
    cntw = cntb = 0
    a = 0
    for ii in range(i, i+8):
      b = 0
      for jj in range(j, j+8):
        if a%2==0 and b%2==0 and map[ii][jj]=="B":
          pass
        elif a%2==0 and b%2!=0 and map[ii][jj]=="W":
          pass
        elif a%2!=0 and b%2==0 and map[ii][jj]=="W":
          pass
        elif a%2!=0 and b%2!=0 and map[ii][jj]=="B":
          pass
        else:
          cntb += 1

        if a%2==0 and b%2==0 and map[ii][jj]=="W":
          pass
        elif a%2==0 and b%2!=0 and map[ii][jj]=="B":
          pass
        elif a%2!=0 and b%2==0 and map[ii][jj]=="B":
          pass
        elif a%2!=0 and b%2!=0 and map[ii][jj]=="W":
          pass
        else:
          cntw += 1
        b += 1
      a += 1
    cnt = min(cntw, cntb)
    minCnt = min(cnt, minCnt)
print(minCnt)