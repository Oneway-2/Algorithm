import itertools


def solution(nums):
    answer = 0
    hy = [True for i in range(3000)]
    for i in range(2, 3000):
        idx = 2
        total = i * idx
        while total < 3000:
            hy[total] = False
            idx += 1
            total = i * idx

    combs = list(itertools.combinations(nums, 3))
    for i in combs:
        idx = sum(i)
        if hy[idx] == True:
            answer += 1

    return answer
