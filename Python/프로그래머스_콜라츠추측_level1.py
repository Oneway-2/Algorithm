def solution(num):
    cnt = 0
    while num != 1:
        if num % 2 != 0:  # 홀수냐
            num *= 3  # 3을 곱합니다
            num += 1  # 거기에 1을 더합니다.
            cnt += 1
        else:  # 짝수냐
            num //= 2  # 2로 나눕니다.
            cnt += 1
        if cnt >= 500:  # 500번 될 때 까지 안되면 break
            cnt = -1
            break
    return cnt
