def solution(s):
    texts = s.split(" ")
    for i in range(len(texts)):
        texts[i] = texts[i].capitalize()
    answer = " ".join(texts)
    return answer
