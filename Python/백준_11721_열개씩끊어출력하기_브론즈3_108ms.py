import sys
input = sys.stdin.readline
text = input().rstrip()
idx = 0
while idx < len(text):
    if idx % 10 == 0 and idx != 0:
        print()
    print(text[idx], end="")
    idx += 1

# 문자열
