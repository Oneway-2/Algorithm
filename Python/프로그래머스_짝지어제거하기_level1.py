from collections import deque


def solution(s):
    nlist = deque(s)
    length = len(nlist)
    idx = 0
    areTextsLeft = False

    while length != 0:
        if idx == length-1:  # 끝까지 도달했거나 length 가 0이됨.
            areTextsLeft = True
            break

        if nlist[idx] == nlist[idx+1]:  # 짝지어진애 발견
            del nlist[idx+1]
            del nlist[idx]
            length -= 2
            idx = 0
            continue

        idx += 1

    if areTextsLeft == True:
        return 0
    else:
        return 1


# 미완
