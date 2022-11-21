import sys
input = sys.stdin.readline
text = input().rstrip()
answer = ''
for t in text:
    # 소문자
    asc = ord(t) + 13
    if 97 <= ord(t) <= 122:
        if asc > 122:
            answer += chr(asc-26)
        else:
            answer += chr(asc)
    # 대문자
    elif 65 <= ord(t) <= 90:
        if asc > 90:
            answer += chr(asc-26)
        else:
            answer += chr(asc)
    else:
        answer += t
print(answer)

# 아스키코드, chr, ord 복습
