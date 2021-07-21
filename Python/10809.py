# s = input()
# for i in range(97, 123):
#     try:
#         print(s.index(chr(i)), end=" ")
#     except ValueError:
#         print(-1, end=" ")

s = input()
for i in range(97, 123):
    print(s.find(chr(i)), end=" ")

# index를 쓰면 없는 값을 찾을 때 ValueError 가 뜨는데 find를 쓰면 없는 값엔 -1를 자동으로 출력해주네.