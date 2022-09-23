import sys
input = sys.stdin.readline
N = int(input())
numList = []
startNum = False
endNum = False
for i in range(N):
    text = input().rstrip()

    tmpNum = ''
    for t in range(len(text)):
        if '0' <= text[t] <= '9':
            if startNum == False:
                endNum = False
                startNum = True
            tmpNum += text[t]
            if t == len(text)-1:  # 마지막거 탐색중
                numList.append(int(tmpNum))
                tmpList = ''
                startNum = False
                endNum = False
        else:
            if startNum == True:
                startNum = False
                endNum = True
                numList.append(int(tmpNum))
                tmpNum = ''

numList.sort()
for i in numList:
    print(i)
