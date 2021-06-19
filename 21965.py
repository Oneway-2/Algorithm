# 드높은 남산 위에 우뚝 선

n = int(input())
nlist = list(map(int, input().split()))
uping = True
for i in range(n):
    if i+1 == n:
        # print("끝도달")
        print("YES")
    elif nlist[i] < nlist[i+1]:
        if uping == False:
            # print("이새끼 올라갔다가 내려갔다 다시올라간다")
            print("NO")
            break
    elif nlist[i] == nlist[i+1]:
        # print("{} -> {} flat, not mountain".format(nlist[i], nlist[i+1]))     
        print("NO")
        break   
    else:
        # print("{} -> {} down".format(nlist[i], nlist[i+1]))
        uping = False