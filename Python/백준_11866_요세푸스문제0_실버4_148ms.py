# 1 2 3 4 5 6 7
# 0 0 0 4 0 0 0 (3 6 2 7 5 1 4)

N, K = map(int, input().split())
orderlist = []
people = list(range(1, N+1))
idx = 1
cnt = N
while True:
    if idx % K == 0:
        orderlist.append(people.pop(0))
        idx = 0
        cnt -= 1
        if cnt <= 0:
            break
    else:
        people.append(people.pop(0))
    idx += 1
result = ", ".join(map(str, orderlist))
print("<" + result + ">")
