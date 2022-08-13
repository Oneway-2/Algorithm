def to3(n):
    rev_base = ''
    while n > 0:
        n, mod = divmod(n, 3)
        rev_base += str(mod)
        # 45%3 = 0 , 15%3 = 0 , 5%3 = 2 , 1%3 = 1
        # 거꾸로하면 1200
    return rev_base[::-1]


def solution(n):
    nto3 = to3(n)  # n 을 3진법으로
    rev_nto3 = nto3[::-1]  # 3진법을 뒤집기
    answer = int(rev_nto3, 3)  # 3진법을 10진수로 바꾸는 함수
    return answer
