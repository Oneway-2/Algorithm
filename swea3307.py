# 최장 증가 부분 수열

# import sys
# TC = int(input())
# for t in range(TC):
#     n = int(sys.stdin.readline())
#     arr = list(map(int, sys.stdin.readline().split()))
#     clist = [[arr[0], 1]]
#     for j in range(1, len(arr)):  # 인덱스 수 증가, 1번 인덱스부터 탐색.
#         for i in range(len(clist)): # clist 내부 탐색
#             if arr[j] >= clist[i][0]:
#                 clist[i][1] += 1
#                 clist[i][0] = arr[j]
#             elif (arr[j] < clist[i][0]) and (i+1 == len(clist)):
#                 clist.append([arr[j], 1])
#         # print("현재 {}번 요소, {}".format(j, clist))
    
#     gather_maximum = []
#     for a in range(len(clist)):
#         gather_maximum.append(clist[a][1])
#     # print(gather_maximum)
#     print("#{} {}".format(t+1, max(gather_maximum)))


TC = int(input())
for t in range(TC):
    n = int(input())
    arr = list(map(int, input().split()))
    clist = [[arr[0], 1]]
    for j in range(1, len(arr)):  # 인덱스 수 증가, 1번 인덱스부터 탐색.
        for i in range(len(clist)): # clist 내부 탐색
            if arr[j] >= clist[i][0]:
                clist[i][1] += 1
                clist[i][0] = arr[j]
            elif (arr[j] < clist[i][0]) and (i+1 == len(clist)):
                clist.append([arr[j], 1])
        print("현재 {}번 요소, {}".format(j, clist))
    
    gather_maximum = []
    for a in range(len(clist)):
        gather_maximum.append(clist[a][1])
    # print(gather_maximum)
    print("#{} {}".format(t+1, max(gather_maximum)))