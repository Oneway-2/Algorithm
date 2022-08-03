import sys
input = sys.stdin.readline
text = input().rstrip()
stack = []
tmp = 1
res = 0

for idx in range(len(text)):
    if text[idx] == "(":
        tmp *= 2
        stack.append(text[idx])
    elif text[idx] == "[":
        tmp *= 3
        stack.append(text[idx])

    elif text[idx] == ")":
        if not stack or stack[-1] == "[":
            res = 0
            break
        if text[idx-1] == "(":
            res += tmp
        tmp //= 2
        stack.pop()

    else:
        if not stack or stack[-1] == "(":
            res = 0
            break
        if text[idx-1] == "[":
            res += tmp
        tmp //= 3
        stack.pop()

if stack:
    res = 0
print(res)

# 뻘짓 야무지게 하다가 그냥 참고함
# 중간중간 나눠서 원래대로 돌려놓는 생각은 어케하는거..
# 참고: https://dev-dain.tistory.com/149
