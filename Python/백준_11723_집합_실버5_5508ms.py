import sys
input = sys.stdin.readline
s = set()

N = int(input())
for _ in range(N):
    text = input().split()
    if len(text) == 1:
        if text[0] == "all":
            s = set([i for i in range(1, 21)])
            continue
        else:
            s = set()
            continue

    else:
        com, idx = text[0], int(text[1])
        if com == "check":
            print(1 if idx in s else 0)
        elif com == "add":
            s.add(idx)
        elif com == "remove":
            s.discard(idx)
        elif com == "toggle":
            if idx in s:
                s.discard(idx)
            else:
                s.add(idx)

# PyPy3 로 채점하면 메모리초과인데 Python3 으로 채점하니까 맞네... 정말 짜증나는군
# 비트마스킹 같은거 필요없고 list가 아닌 set으로 풀면 되는문제였다.
