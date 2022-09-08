def solution(n):
    _filter = [True] * 1000001  # 0 ~ 1000000 True는 소수
    for i in range(2, n+1):
        idx = 2
        total = i * idx
        while total <= n:
            _filter[total] = False
            idx += 1
            total = i * idx
    answer = 0
    for i in range(2, n+1):
        if _filter[i] == True:
            answer += 1

    return answer
