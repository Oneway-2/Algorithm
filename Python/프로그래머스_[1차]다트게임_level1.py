def solution(dartResult):
    setScore = [0, 0, 0]
    checkedScore = False
    idx = 0
    score = ""
    intScore = 0
    intBonus = 0
    total = 0

    for i in dartResult:
        print("현재 : {}, idx = {}".format(i, idx), end=" ")
        if "0" <= i <= "9":
            score += i
            checkedScore = True

        elif checkedScore == True and (i == "S" or i == "D" or i == "T"):
            intScore = int(score)
            if i == "S":
                intBonus = 1
            elif i == "D":
                intBonus = 2
            elif i == "T":
                intBonus = 3

            total = intScore ** intBonus
            setScore[idx] = total

            score = ""
            intScore = 0
            intBonus = 0
            idx += 1

            checkedScore = False

        if i == "*":
            for j in range(1, 3):
                aidx = idx-j
                if aidx >= 0:
                    setScore[aidx] *= 2

        if i == "#":
            aidx = idx-1
            setScore[aidx] *= -1

        print(setScore)

    answer = sum(setScore)
    return answer
