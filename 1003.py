# fibonacci function

import sys

def Fibo(until):
    count = 2
    n_1, n_2, new_n = 1, 0, 1
    while count <= until:
        new_n = n_1 + n_2    
        count += 1
        n_2 = n_1
        n_1 = new_n
    if until == 0:
        # print(0)
        return 0
    else:
        # print(new_n)
        return new_n

t = int(input())
for i in range(t):        
    until = int(sys.stdin.readline())
    print(Fibo(until-1), Fibo(until))  

# 처음에 재귀함수로 해결하려다가 계속 시간초과 떠서 10870번 풀었던 코드 갖다가 사용함.