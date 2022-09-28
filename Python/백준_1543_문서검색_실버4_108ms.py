import sys
input = sys.stdin.readline

T = input()
text = input().rstrip()

leng = len(text)
idx = 0
answer = 0
while idx < len(T)-leng:
    if T[idx:idx+leng] == text:
        # print("idx = {} 맞다잉?".format(idx))
        idx += leng
        answer += 1
    else:
        idx += 1

print(answer)
