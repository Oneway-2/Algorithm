def solution(n):
    ans = 0

    while n != 0:
        n, rem = divmod(n, 2)
        if rem != 0:
            ans += 1

    return ans
