from collections import deque

from collections import deque


def solution(s):
    nlist = deque()

    for i in range(len(s)):
        if len(nlist) == 0:
            nlist.append(s[i])
        elif s[i] == nlist[-1]:
            nlist.pop()
        else:
            nlist.append(s[i])

    if len(nlist) == 0:
        return 1
    else:
        return 0


# 1. 인덱스를 0부터 다 찾는방식을 이용해봤는데 시간초과가 난다.
# 2. deque를 사용하면 시간복잡도를 엄청나게 줄일 수 있따.
