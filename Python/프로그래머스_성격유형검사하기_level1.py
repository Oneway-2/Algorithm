def solution(survey, choices):
    dicts = {"R": 0, "T": 0, "C": 0, "F": 0, "J": 0, "M": 0, "A": 0, "N": 0}
    length = len(survey)
    for i in range(length):
        sur1 = survey[i][0]
        sur2 = survey[i][1]
        cho = choices[i]

        if cho == 4:
            continue
        elif cho == 1:
            dicts[sur1] += 3
        elif cho == 2:
            dicts[sur1] += 2
        elif cho == 3:
            dicts[sur1] += 1
        elif cho == 5:
            dicts[sur2] += 1
        elif cho == 6:
            dicts[sur2] += 2
        elif cho == 7:
            dicts[sur2] += 3

    answer = ""
    if dicts["R"] >= dicts["T"]:
        answer += "R"
    else:
        answer += "T"
    if dicts["C"] >= dicts["F"]:
        answer += "C"
    else:
        answer += "F"
    if dicts["J"] >= dicts["M"]:
        answer += "J"
    else:
        answer += "M"
    if dicts["A"] >= dicts["N"]:
        answer += "A"
    else:
        answer += "N"

    return answer
