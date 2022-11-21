import sys
input = sys.stdin.readline
TC = int(input())
for tc in range(TC):
    answer = 0
    a, b = map(int, input().split(" "))
    for num in range(a, b+1):
        snum = str(num)
        answer += snum.count("0")
    print(answer)

# str, count
