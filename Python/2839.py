n = int(input())
til = n // 5
for i in range(til, -1, -1):
    if (n - (5*i)) % 3 == 0:
        v3 = (n - (5*i)) // 3        
        print(i+v3)
        break
    elif i == 0:
        print(-1)