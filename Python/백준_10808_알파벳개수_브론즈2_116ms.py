s = input()
nlist = [0 for i in range(26)]
for i in s:
    nlist[ord(i) % 97] += 1
for i in nlist:
    print(i, end=" ")
