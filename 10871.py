n, x = map(int, input().split())
a_list = list(map(int, input().split()))
for i in a_list:
    if i < x:
        print(i, end=" ")