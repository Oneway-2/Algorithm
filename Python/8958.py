def Calculate_score(result):
    score = 0
    ascending = 0

    for i in range(len(result)):
        if result[i] == 'O':
            ascending += 1
        else:
            ascending = 0
        score += ascending
    return score

n = int(input())
for i in range(n):
    result = list(input())
    print(Calculate_score(result))