a, b, c = map(int, input().split())
if b>c or b==c:
    print(-1)
else:
    x = a//(c-b) + 1
    print(x)

# 분모가 0 이 될 수 있다는 사실을 망각해서 1번 틀림..