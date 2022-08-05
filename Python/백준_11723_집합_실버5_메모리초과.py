import sys
input = sys.stdin.readline
group = [False] * 21
N = int(input())
for i in range(N):
    command = input().rstrip()
    if command == "all":
        for j in range(21):
            group[j] = True
        continue
    elif command == "empty":
        for j in range(21):
            group[j] = False
        continue
    com, idx = command.split()
    idx = int(idx)
    if com == "add":
        group[idx] = True
    elif com == "remove":
        group[idx] = False
    elif com == "toggle":
        group[idx] = not group[idx]
    else:
        if group[idx] == True:
            print(1)
        else:
            print(0)
