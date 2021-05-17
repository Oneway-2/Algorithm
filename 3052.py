number_list = []
remainder_list = []

for i in range(10):
    n = int(input())
    number_list.append(n)

count = 0
for i in range(10):
    remainder_list.append(number_list[i]%42)
    already_exist = remainder_list.count(remainder_list[i])
    if already_exist == 1:
        count += 1
print(count)