sum = 0
min = 9999999999
for i in range(7):
    s = int(input())
    if s % 2 == 1:
        sum += s
        if s < min:
            min = s
if s == 0:
    print(-1)
else:
    print(sum)
    print(min)
