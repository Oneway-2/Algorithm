# 단어 정렬

import sys
t = int(input())
nlist = []
for _ in range(t):
    word = sys.stdin.readline().rstrip()
    if word not in nlist:
        nlist.append(word)
f = len(nlist)

# print(nlist)
for j in range(f-1, 0, -1):
    # print(j)
    # print("\n")
    for i in range(j):
        if len(nlist[i]) == len(nlist[i+1]):
            # print("{}와 {}는 검사가 필요하다".format(nlist[i], nlist[i+1]))
            l = len(nlist[i])
            o = 0
            for o in range(l):
                if nlist[i][o] > nlist[i+1][o]:
                    # print("{}와 {}는 {}번째 단어가 서로 달라서 바꾼다.".format(nlist[i], nlist[i+1], o+1))
                    tmp = nlist[i+1]
                    nlist[i+1] = nlist[i]
                    nlist[i] = tmp
                    break
                elif nlist[i][o] == nlist[i+1][o]:
                    pass
                    # print("{}와 {}는 {}번째 단어가 서로 다른데 다음 글자를 보자.".format(nlist[i], nlist[i+1], o+1))
                else:
                    # print("{}와 {}는 {}번째 단어가 서로 다르지만 바꿀필요 없다.".format(nlist[i], nlist[i+1], o+1))
                    break
            # print(nlist)

        elif len(nlist[i]) > len(nlist[i+1]):
            # print("{}와 {}는 자리를 바꾸자".format(nlist[i], nlist[i+1]))
            tmp = nlist[i+1]
            nlist[i+1] = nlist[i]
            nlist[i] = tmp
            # print(nlist)
            
        else:
            pass
            # print(nlist)

for w in nlist:
    print(w)


# 시간초과됨