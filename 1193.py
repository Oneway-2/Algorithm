# 분수 찾기

n = int(input())

num = 0
total = 0

while n > total:
    num += 1
    total += num

s = total - num

if num % 2 != 0: 
    x = num - (n - s) + 1
    y = n - s
else:
    x = n - s
    y = num - x + 1

print("{}/{}".format(x, y))