# 삼각형 만들기

n = int(input())
til = int(n/3 + 1)
cnt = 0
for a in range(1, til):
    # print(a)
    rem = n-a
    for b in range(a, rem): # 어차피 rem까지 가기전에 break됨
        c = rem-b        
        if b > c:
            # print("b가 더 커졌으니 break")
            break
        # print("a={},b={},c={}".format(a,b,c))        
        if a+b > c:
            # print("당신은 합격")
            cnt += 1         
print(cnt)