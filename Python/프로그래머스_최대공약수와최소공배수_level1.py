def solution(n, m):
    answer = []
    GCD = 1  # 최대공약수
    LCM = 1  # 최소공배수
    large = max(n, m)
    exit = True
    if n == 1 or m == 1:
        GCD = large
        LCM = 1
        exit = False

    i = 2
    while exit:
        if n % i == 0 and m % i == 0:
            GCD *= i
            n //= i
            m //= i
            large //= i
            i = 2
        else:
            i += 1
            if i > large:
                LCM = GCD * n * m
                break

    # print("GCD = {}, LCM = {}".format(GCD, LCM))
    answer.append(GCD)
    answer.append(LCM)
    return answer
