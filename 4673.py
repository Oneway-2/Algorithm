# 셀프 넘버
numbers = list(range(1, 10001)) 
for i in range(1, 10001):
    dn = 0
    digit = str(i)
    dn += i
    for j in digit:
        dn += int(j)
    try:
        numbers.remove(dn)
    except ValueError:
        continue
for i in numbers:
    print(i)

# 내장함수 안쓰면 더 빠르다.