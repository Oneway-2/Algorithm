# 일곱난쟁이

import sys
nlist = []
for _ in range(9):
    nlist.append(int(sys.stdin.readline()))
rest = sum(nlist)-100
nlist.sort()
# print(nlist)
flag = True
for i in range(9):
    if flag == False: break
    for j in range(i+1, 9):
        # print(nlist[i], nlist[j])
        if nlist[i] + nlist[j] == rest:
            # print("범인은 {}와 {}".format(nlist[i], nlist[j]))
            d,f = nlist[i], nlist[j]
            nlist.remove(d)
            nlist.remove(f)
            flag = False
            break
        elif nlist[i] + nlist[j] > rest:
            # print("초과했으니 멈춰")
            break
for k in nlist:
    print(k)