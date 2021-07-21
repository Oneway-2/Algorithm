# 한수
n = int(input())
count = 0

for i in range(1, n+1):
    if i < 100:
        count += 1
    else:
        stri = str(i)
        if (int(stri[1])-int(stri[0])) == (int(stri[2])-int(stri[1])):
            count += 1    
print(count)

# 형변환 말고 // 써서 자릿수 구할 수 있음