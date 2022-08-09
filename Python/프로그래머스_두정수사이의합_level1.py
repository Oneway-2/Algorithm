def solution(a, b):
    na = min(a, b)
    nb = max(a, b)
    answer = 0
    for i in range(na, nb+1):
        answer += i
    return answer
