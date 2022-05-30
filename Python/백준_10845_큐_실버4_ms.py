import sys
input = sys.stdin.readline
N = int(input())
for i in range(N):
    s = input().strip()
    ends = s[-1]
    print(ord(ends))
    if 48 <= ord(ends) and ord(ends) <= 57:
        # push 연산
        pass
    else:
        if s == "pop":
            print("pop 수행")
        elif s == "size":
            print("size 수행")
        elif s == "empty":
            print("empty 수행")
        elif s == "front":
            print("front 수행")
        elif s == "back":
            print("back 수행")
