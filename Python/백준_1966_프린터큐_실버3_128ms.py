TC = int(input())
for _ in range(TC):
    cnt = 1
    N, M = map(int, input().split())
    qu = list(map(int, input().split()))
    orderqu = list(range(N))
    orderqu[M] = -1
    while True:
        # 가장 우선순위 높은애가 왔으면
        if qu[0] == max(qu):
            # 그런데 내가 뽑고싶은애면? 끝냅니다.
            if orderqu[0] == -1:
                print(cnt)
                break
            # 내가 뽑고싶은애가 아니면? 빼서 버립니다.
            else:
                qu.pop(0)
                orderqu.pop(0)
                cnt += 1
            # 가장 우선순위 높은애가 아니면
        else:
            # 젤 앞 녀석을 젤 뒤로 보냅니다.
            a = qu.pop(0)
            ora = orderqu.pop(0)
            qu.append(a)
            orderqu.append(ora)
