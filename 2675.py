import sys
t = int(input())
for i in range(t):
    r, s = sys.stdin.readline().split()
    r = int(r)
    s_list = list(s)
    s_new_list = []
    for j in s_list:
        s_new_list.append(j*r)
    new_s = ''.join(s_new_list)
    print(new_s)

# list 안쓰고 풀면 더 좋다.