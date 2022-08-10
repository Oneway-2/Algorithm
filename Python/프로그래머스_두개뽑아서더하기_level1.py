import itertools


def solution(numbers):
    answer = set()
    total = list(itertools.combinations(numbers, 2))
    for i in total:
        answer.add(sum(i))
    print(answer)
    answer = list(answer)
    answer.sort()
    return answer
