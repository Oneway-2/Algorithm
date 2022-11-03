def solution(n):
    fibolist = [0] * 100001
    fibolist[1] = 1
    fibolist[2] = 1
    for i in range(3, 100001):
        fibolist[i] = fibolist[i-1] + fibolist[i-2]
    answer = fibolist[n] % 1234567
    return answer
