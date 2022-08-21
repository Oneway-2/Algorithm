def solution(participant, completion):
    pdict = dict()
    hashsum = 0
    for i in participant:
        pdict[hash(i)] = i
        hashsum += hash(i)

    for i in completion:
        hashsum -= hash(i)

    answer = pdict[hashsum]
    return answer

# def solution(participant, completion):
#     for i in completion:
#         participant.remove(i)
#     answer = participant[0]
#     return answer

# 반드시 해쉬 자료구조를 사용해야함.
# 파이썬은 dict 자료구조가 해쉬구조임.
