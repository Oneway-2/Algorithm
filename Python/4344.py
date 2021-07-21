import sys

def get_average(scores):
    sum = 0
    for i in range(1, len(scores)):
        sum += scores[i]
    return sum / scores[0]

def get_over_average_count(scores, average):
    count = 0
    for i in range(1, len(scores)):
        if scores[i] > average:
            count += 1
    return count


n = int(input())
for i in range(n):
    scores = list(map(int, sys.stdin.readline().split()))
    average = get_average(scores)
    count = get_over_average_count(scores, average)
    over_average_percentage = count/scores[0]*100
    print("{:.3f}%".format(over_average_percentage))