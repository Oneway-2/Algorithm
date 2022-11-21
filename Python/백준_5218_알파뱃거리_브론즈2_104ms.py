import sys
input = sys.stdin.readline
TC = int(input())
for tc in range(TC):
    answer = 'Distances:'
    a, b = map(str, input().rstrip().split(" "))
    for ia, ib in zip(a, b):
        oa, ob = ord(ia), ord(ib)
        dif = 0
        if ob >= oa:
            dif = ob - oa
        else:
            dif = (ob + 26) - oa
        answer += ' '+str(dif)
    print(answer)

# 문자열, 아스키코드
