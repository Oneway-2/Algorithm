n = int(input())
nlist = list(map(int, input().split()))
print(nlist)
odd_nums = [num for num in nlist if num % 2 == 1]
print(odd_nums)