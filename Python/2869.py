# 달팽이는 올라가고 싶다.
a, b, v = map(int, input().split())
x = (v-b)//(a-b)
if (v-b)%(a-b) == 0:
    print(x)
else:
    print(x+1)