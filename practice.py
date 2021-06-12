alist = []
for _ in range(8):
    number = int(input())
    alist.append(number)
num_max = max(alist)
print(num_max)
print(alist.index(num_max)+1)

