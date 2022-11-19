import sys
input = sys.stdin.readline

scoreList = []
for i in range(1, 9):
    score = int(input())
    scoreList.append([score, i])
scoreList.sort(reverse=True)

answer = 0
answerList = []
for s in scoreList[:5]:
    answer += s[0]
    answerList.append(str(s[1]))
answerList.sort()

print(answer)
print(" ".join(answerList))
