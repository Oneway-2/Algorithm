import sys
input = sys.stdin.readline
TC = int(input())
for tc in range(TC):
    text = input().rstrip()
    print(text[0] + text[-1])

# 문자열
