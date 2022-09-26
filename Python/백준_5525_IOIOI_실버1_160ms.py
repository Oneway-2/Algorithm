import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
S = input()

cnt = 0
answer = 0
stack = []

for i in range(M):
    if S[i] == "O":
        continue
    else:
        stack.append(i)

for i in range(1, len(stack)):
    if stack[i] - stack[i-1] == 2:
        cnt += 1
    else:
        cnt = 0

    if cnt >= N:
        answer += 1

print(answer)

# 내가 생각한 시간초과의 요인:
# 1. 'IOIOI' 이런 문자열 형태를 직접 만드는거 자체가 시간손실

# text = ''
# for i in range(N):
#     text += 'IO'
# text += 'I'

# a = len(text)

# answer = 0
# idx = 0
# while idx <= M-a:
#     if text == S[idx:idx+a]:
#         answer += 1
#         idx += 2
#     else:
#         idx += 1

# print(answer)

# 1 IOI 3
# 2 IOIOI 5
# 3 IOIOIOI 7
# 4 IO IO IO IO I 9

# print("걸린시간 : ", time.time()-start)
