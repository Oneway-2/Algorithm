import sys
import re
input = sys.stdin.readline
answer = []
for i in range(5):
    txt = input()
    com = re.compile("FBI")
    res = com.search(txt)
    if res != None:
        answer.append(i+1)

if len(answer) == 0:
    print("HE GOT AWAY!")
else:
    print(" ".join(map(str, answer)))

# 정규표현식 기초 연습
