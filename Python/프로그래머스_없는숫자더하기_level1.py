def solution(numbers):
    numList = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    for i in numbers:
        numList.remove(i)
    answer = sum(numList)
    return answer
