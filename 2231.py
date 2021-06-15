# 분해합

def Get_Hap(h):
    sum = int(h)
    for i in range(len(h)):
        sum += int(h[i])
    return sum

nstr = input()
n = int(nstr)

if 2<=n and n<=10:
    for h in range(1,6):
        sum = Get_Hap(str(h))
        if sum == n:
            print(h)
            break
        if h == 5:
            print(0)
            break

elif 11<=n and n<=18:
    for h in range(6,14):
        sum = Get_Hap(str(h))
        if sum == n:
            print(h)
            break        
        if h == 13:
            print(0)
            break

elif n>=19:
    digit = len(nstr)
    r_min = n-9*digit
    r_max = n+9*digit
    for h in range(r_min, r_max+1):
        sum = Get_Hap(str(h))        
        if sum == n:
            print(h)
            break
        if h == r_max:
            print(0)
            break

else:
    print(0)
       

# 216을 치면 198을 내놓는게 문제임.
# 216을 치면 그게 어느 범위인지부터 확인
# 그 이후 그 범위에 있는놈들을 차례로 검사, 216가 나오는 놈을 저장. 그녀석이 생성자.