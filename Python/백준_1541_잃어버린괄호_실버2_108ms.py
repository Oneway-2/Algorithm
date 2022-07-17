import sys
input = sys.stdin.readline
a = input().rstrip().split('-')
# print(a)
result = 0
for i in a[0].split("+"):
    result += int(i)
for i in a[1:]:
    for j in i.split("+"):
        result -= int(j)
print(result)
