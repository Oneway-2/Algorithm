# black jack

n, m = map(int, input().split())
a = list(map(int, input().split()))
max, end = 0, 0
for i in range(n-2):
    if end == 1: break
    for j in range(i+1, n-1):
        if end == 1: break
        for h in range(j+1, n):
            t_max = a[i]+a[j]+a[h]
            if t_max == m:
                max = t_max
                end = 1
                break
            elif t_max < m:
                if max < t_max:
                    max = t_max
print(max)