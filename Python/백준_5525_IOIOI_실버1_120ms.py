import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
s = input()

text = ''
for i in range(N):
    text += 'IO'
text += 'I'
a = len(text)

answer = 0
for i in range(len(s)-a):
    if text == s[i:i+a]:
        answer += 1

print(answer)

# 1 IOI 3
# 2 IOIOI 5
# 3 IOIOIOI 7
# 4 IO IO IO IO I 9
