def solution(price, money, count):
    total = 0
    for i in range(1, count+1):
        total += price * i
    result = money - total
    answer = 0
    if result >= 0:
        answer = 0
    else:
        answer = abs(result)

    return answer
