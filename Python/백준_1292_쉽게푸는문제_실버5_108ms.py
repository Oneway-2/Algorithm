numbers = []
idx = 1
flag = False
for i in range(1, 1001):
    if flag == True:
        break
    for j in range(1, i+1):
        numbers.append(i)
        idx += 1
        if idx > 1000:
            flag = True

sum = 0
a, b = map(int, input().split())
for i in range(a-1, b):
    sum += numbers[i]
print(sum)
