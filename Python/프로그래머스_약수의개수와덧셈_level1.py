def solution(left, right):
    answer = 0
    for number in range(left, right+1):
        count = []  # 어차피 1 이랑 자기 자신은 무조건 약수임.

        for i in range(2, right+1):
            if number % i == 0:  # 나누지면 약수임
                count.append(i)
        count.append(1)
        print(count)
        if len(count) % 2 != 0:  # 홀수면
            answer -= number
        else:  # 짝수면
            answer += number

    return answer
