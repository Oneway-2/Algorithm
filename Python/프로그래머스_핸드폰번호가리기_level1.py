def solution(phone_number):
    length = len(phone_number)
    answer = ''
    for i in range(length-4):
        answer += "*"
    answer += phone_number[-4:]
    return answer
