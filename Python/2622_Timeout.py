# 삼각형 만들기

n = int(input())
abc = [0,0,0]
exist = []
til = int(n/3 + 1)
for a in range(1, til):
    # print(a)
    rem = n-a
    for b in range(1, rem): # 어차피 rem까지 가기전에 break됨
        c = rem-b        
        if b > c:
            # print("b가 더 커졌으니 break")
            break
        # print("a={},b={},c={}".format(a,b,c))
        abc = sorted([a,b,c])
        # print(abc)
        if a==b and b==c and c==a:
            exist.append(abc)
            # print("당신은 정삼각형")
        elif abc[0]+abc[1] > abc[2]:
            if abc in exist:
                # print("당신은 이미 존재하는걸요")
                continue
            # print("당신은 합격")
            exist.append(abc)      
    a += 1    
# print(exist)
print(len(exist))