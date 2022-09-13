def solution(s):
    answer = True

    stack = ["."]

    # 가장 처음에 ")" 가 오는경우 out of index 방지용 "." 가 지워지는걸 막기
    if len(stack) == 1 and s[0] == ")":
        return False

    for i in s:
        if i == "(":
            stack.append(i)
        if i == ")":
            if stack[-1] == "(":
                stack.pop()

    if len(stack) >= 2:
        answer = False

    return answer
