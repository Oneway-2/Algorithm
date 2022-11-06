def solution(n):
    answer = 0
    cur = 0
    start = 1
    num = 1

    while start <= n:
        cur += num
        # print("start = {}, num = {}, cur = {}".format(start, num, cur))

        if cur >= n:
            if cur == n:
                answer += 1
            cur = 0
            start += 1
            num = start
        else:
            num += 1

    return answer

# n이 10000 이하이기 때문에 그냥 brute force로 1부터 10000까지 달렸다.
