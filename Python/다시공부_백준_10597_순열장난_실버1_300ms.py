import sys
input = sys.stdin.readline
num = input().rstrip()
if len(num) < 10:
    maxLen = len(num)
else:
    maxLen = 9 + (len(num)-9)//2


def make(idx, c):
    global end, ans
    if end:
        return
    if idx == len(num):
        if c == maxLen:
            end = True
            ans = " ".join(map(str, tmp))
        return

    num1 = int(num[idx])
    if not used[num1]:
        used[num1] = True
        tmp[c] = num1
        make(idx+1, c+1)
        used[num1] = False
    if idx < len(num) - 1:
        num2 = int(num[idx:idx+2])
        if num2 < maxLen+1 and not used[num2]:
            used[num2] = True
            tmp[c] = num2
            make(idx+2, c+1)
            used[num2] = False


used = [0 for i in range(maxLen + 1)]
tmp = [0 for i in range(maxLen)]
end = False
make(0, 0)
print(ans)
