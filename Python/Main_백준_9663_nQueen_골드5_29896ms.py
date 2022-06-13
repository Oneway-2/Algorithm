N = int(input())
mmap = [0 for i in range(N)]
result = 0


def check(x):
    for i in range(x):
        if mmap[x] == mmap[i] or abs(mmap[x] - mmap[i]) == abs(x - i):
            return False
    return True


def setQueens(cnt):
    global result
    if cnt == N:
        result += 1
        return
    for i in range(N):
        mmap[cnt] = i
        if check(cnt):
            setQueens(cnt+1)


setQueens(0)
print(result)
