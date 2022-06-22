import sys
input = sys.stdin.readline
R, C = map(int, input().split())
mmap = [[] for i in range(R)]
for i in range(R):
    s = input().rstrip()
    for j in s:
        mmap[i].append(j)

starPos = list()
minGap = 10000
for c in range(C):
    countGap = 0
    for r in range(R):
        if mmap[r][c] == "X":
            # 내려가다 유성조각 만나면 다시셈
            countGap = 0
            starPos.append((r, c))
        elif mmap[r][c] == ".":
            countGap += 1
        else:
            minGap = min(countGap, minGap)
            break

newStarPos = tuple(map(lambda item: [item[0] + minGap, item[1]], starPos))

for r, c in starPos:
    mmap[r][c] = "."
for nr, nc in newStarPos:
    mmap[nr][nc] = "X"

for i in mmap:
    for j in i:
        print(j, end="")
    print()
