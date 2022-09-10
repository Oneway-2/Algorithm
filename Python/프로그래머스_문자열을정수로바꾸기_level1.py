def solution(s):
    answer = 0
    if s[0] == "-":
        num = int(s[1:])
        answer -= num
    else:
        num = int(s)
        answer += num

    return answer
