# 임시반장정하기

import sys
numbers = int(input())
table = [[0 for i in range(5)] for i in range(numbers)]
for i in range(numbers):
    table[i] = list(map(int, sys.stdin.readline().split()))
    
count = [False for _ in range(numbers)]

for n in range(numbers):
    visited = [False for _ in range(numbers)]
    for grade in range(5):
        for ck in range(numbers):
            if ck != n and table[ck][grade] == table[n][grade]:  # 같은녀석을 비교할 필요 없음 and 자신 빼고 다른애들 전부 비교해서 같은애가 있다면
                visited[ck] = True  # 그 녀석과 나는 아는사이임
    count[n] = len(list(filter(lambda x:x, visited)))

print(count.index(max(count))+1)