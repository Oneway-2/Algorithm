import sys
input = sys.stdin.readline
N = int(input())
nlist = []
for i in range(N):
    s = input().strip()
    ends = s[-1]
    if 48 <= ord(ends) and ord(ends) <= 57:
        # push 연산
        nlist.append(s.split()[1])
    else:
        if s == "pop":
            # print("pop 수행")
            if len(nlist) == 0:
                print(-1)
            else:
                print(nlist.pop(0))
        elif s == "size":
            # print("size 수행")
            print(len(nlist))
        elif s == "empty":
            # print("empty 수행")
            if len(nlist) == 0:
                print(1)
            else:
                print(0)
        elif s == "front":
            # print("front 수행")
            if len(nlist) == 0:
                print(-1)
            else:
                print(nlist[0])
        elif s == "back":
            # print("back 수행")
            if len(nlist) == 0:
                print(-1)
            else:
                print(nlist[-1])
