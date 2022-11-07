import sys
from collections import deque
input = sys.stdin.readline

TC = int(input())
for tc in range(TC):
    isReversed = False
    isError = False
    text = input().rstrip()
    n = int(input())
    try:
        nlist = list(map(int, (input().rstrip()[1:-1].split(","))))
    except:
        nlist = []
    queue = deque()
    for i in nlist:
        queue.append(i)

    for order in text:
        if order == "R":
            isReversed = not isReversed
        elif order == "D":
            if len(queue) == 0:
                isError = True
                break
            else:
                if isReversed == False:
                    queue.popleft()
                else:
                    queue.pop()

    result = list(map(str, queue))
    if isError == True:
        print("error")
    else:
        if isReversed == False:
            print("[" + ",".join(result) + "]")
        else:
            print("[" + ",".join(result[::-1]) + "]")
