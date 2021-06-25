alist = ['wont','wait','more']
blist = ['a','b','c','d','e','f','g','h','i']
alist.sort()
for i in range(len(alist)):
    blist[i+2] = alist[i]
print(blist)