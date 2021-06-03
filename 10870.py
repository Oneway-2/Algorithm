# 피보나치 수 5 (Fibonacci numbers)

until = int(input())
count = 2
n_1, n_2, new_n = 1, 0, 1
while count <= until:
    new_n = n_1 + n_2    
    count += 1
    n_2 = n_1
    n_1 = new_n
if until == 0:
    print(0)
else:
    print(new_n)

# def Fibonacci_numbers(n_1, n_2, count):
#     new_n = n_1 + n_2
#     count += 1
#     if count >= until:
#         print(new_n)
#         return 0
#     else:
#         Fibonacci_numbers(new_n, n_1, count)

# until = int(input())
# count = 1
# Fibonacci_numbers(1, 0, count)

# 1. 처음에 재귀함수 썼다가 Recursion Error 계속 떠서 수정함. 확실히 엄청 커다란 수를 입력하면 에러가 뜬다.
# 2. 아니 Fn = Fn-1 + Fn-2 (n ≥ 2) 라고 조건 박아놨으면서 입력조건엔 n은 20보다 작거나 같은 자연수 또는 0이라고 박아놓는건 뭐냐? 0이랑 1 조건 안따졌다가 어디서 틀린지 모르고 엄한 곳 수정했다가 연달아서 틀렸네.