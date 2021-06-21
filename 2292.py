# 벌집

n = int(input())
d = 1
while True:
    dsn = 3*d*d - 3*d + 1
    if n <= dsn:
        # print("n={}, dsn={}, d={}".format(n, dsn, d))
        print(d)
        break
    d+=1

# 뭔가 반복문 쓰면 시간초과로 안풀릴 줄 알았는데 풀리네