import re
import sys
input = sys.stdin.readline

# ===== 3차 풀이 ===== 196ms
T = input().rstrip()
text = input().rstrip()
regex = re.compile(text)
cnt = 0
while True:
    m = regex.search(T)
    if not m:
        break
    cnt += 1
    T = T[m.end():]
print(cnt)


# ===== 2차 풀이 ===== 116ms
# T = input().rstrip()
# text = input().rstrip()
# print(T.count(text))


# ===== 1차 풀이 ===== 108ms
# T = input()
# text = input().rstrip()

# leng = len(text)
# idx = 0
# answer = 0
# while idx < len(T)-leng:
#     if T[idx:idx+leng] == text:
#         # print("idx = {} 맞다잉?".format(idx))
#         idx += leng
#         answer += 1
#     else:
#         idx += 1

# print(answer)
