# fibonacci function

def fibonacci(n, cz, co):
    if (n == 0):
        cz, co = 1, 0
        return cz, co
    elif (n == 1):
        cz, co = 0, 1
        return cz, co
    else:
        a = fibonacci(n-1, cz, co)
        b = fibonacci(n-2, cz, co)
        return a[0]+b[0], a[1]+b[1]

t = int(input())
for i in range(t):
    cz, co = 0, 0
    f = int(input())
    a, b = fibonacci(f, cz, co)
    print(a, b)

# 시간초과 남