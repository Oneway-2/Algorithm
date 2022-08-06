import sys
input = sys.stdin.readline
total = 0
N = int(input())
for i in range(N):
    text = input().rstrip()
    if text == "all":
        total = (1 << 20) - 1
        continue
    elif text == "empty":
        total = 0
        continue

    com, idx = text.split()
    idx = int(idx)
    check = (total & (1 << idx-1)) == (1 << idx-1)
    if com == "check":
        if check == True:
            print(1)
        else:
            print(0)
    elif com == "add":
        if check == False:
            total = total ^ (1 << idx-1)
    elif com == "remove":
        if check == True:
            total = total ^ (1 << idx-1)
    elif com == "toggle":
        total = total ^ (1 << idx-1)
