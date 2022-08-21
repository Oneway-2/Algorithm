def solution(arr):
    temp = -1
    answer = []
    for i in arr:
        if i == temp:
            continue
        temp = i
        answer.append(i)
    return answer
