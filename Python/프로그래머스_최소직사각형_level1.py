def solution(sizes):
    longSide = []
    shortSide = []
    for i in range(len(sizes)):
        if sizes[i][0] > sizes[i][1]:
            longSide.append(sizes[i][0])
            shortSide.append(sizes[i][1])
        else:
            longSide.append(sizes[i][1])
            shortSide.append(sizes[i][0])

    answer = max(longSide) * max(shortSide)
    return answer
