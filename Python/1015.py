# 수열 정렬

n = int(input())
nlist = list(map(int, input().split()))
s_nlist = sorted(nlist)
# print(s_nlist)
ex_dup = {}
for i in nlist:
    if i not in ex_dup:
        ex_dup[i] = s_nlist.index(i)
        # print("{} 키를 만들어서 현재 {}".format(i, ex_dup[i]))
    else:
        ex_dup[i] += 1
        # print("{} 키의 value는 현재 {}".format(i, ex_dup[i]))
    # print(ex_dup)
    print(s_nlist.index(i, ex_dup[i]), end=" ")

