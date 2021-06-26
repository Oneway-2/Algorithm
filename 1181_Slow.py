# 단어 정렬

import sys
t = int(input())
nlist = []
for _ in range(t):
    word = sys.stdin.readline().rstrip()
    if word not in nlist:
        nlist.append(word) 
# print(nlist)
nlist.sort(key=len)
# print(nlist)

arrange_flag = 0
count = 1
start_point = 0

for i in range(len(nlist)-1):
    if len(nlist[i]) == len(nlist[i+1]): # 이전것과 길이가 같으면? flag on, count += 1
        if arrange_flag == 0:  # 시작할때 포인트 잡음
            start_point = i
        count += 1
        arrange_flag = 1
    else:  # 이전것과 길이가 달라지면? flag off
        arrange_flag = 0
    
    if (arrange_flag == 0 and count > 1) or i == len(nlist)-2:  # flag off 가 됐단 뜻은 이제 정렬할 차례라는 것. start_point와 count를 가지고 정렬한다.
        arrange_list = []
        for j in range(count):
            arrange_list.append(nlist[start_point+j])
        arrange_list.sort()
        for k in range(count):
            nlist[start_point+k] = arrange_list[k]
        count = 1

for w in nlist:
    print(w)
    

# 통과는 했으나 엄청나게 느림