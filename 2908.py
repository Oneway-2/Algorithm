# 상수
a, b = input().split()
aa = int(''.join([a[2],a[1],a[0]]))
bb = int(''.join([b[2],b[1],b[0]]))
if aa > bb:
    print(aa)
else:
    print(bb)