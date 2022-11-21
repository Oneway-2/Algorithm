import sys
input = sys.stdin.readline
while True:
    encrText = input().rstrip()
    if encrText == "END":
        break
    answer = ''
    for t in encrText[::-1]:
        answer += t
    print(answer)

# 문자열
