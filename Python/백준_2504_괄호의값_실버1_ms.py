import sys
input = sys.stdin.readline
text = input().rstrip()
stack = []
answer = []
wrong = False
closed = False
didAdd = False

# 열리는 괄호가 나오면 (는 (2 이고 [ 는 (3
# 여는 괄호가 두번나오면 *(
# 닫히는게 등장했을 때 잘 닫히고 다음거가 또 닫히는거면 ), 다음거가 열리는거면 )+

for i in range(len(text)):
    cur = text[i]
    stack.append(cur)

    # 처음
    if len(stack) == 1:
        if cur == "(":
            answer.append("(2")
        elif cur == "[":
            answer.append("(3")
        continue

    prev = stack[-2]

    # # step 0 : 닫힌거 이어서 체크
    # if closed == True:
    #     # 닫혔다가 열렸는가?
    #     if cur == "(" or cur == "[":
    #         answer.append(")+")
    #         closed = False
    #         didAdd = True
    #     # 연속으로 닫혔는가?
    #     elif cur == ")" or cur == "]":
    #         answer.append(")")

    # step 1 : 부호 결정
    # 열렸는가?
    if cur == "(" or cur == "[":
        # 두 번 연속 열리는가?
        if prev == "(" or prev == "[":
            # 이미 부호를 붙였나?
            # if didAdd == True:
            #     didAdd = False
            # else:
            answer.append("*(")
    # 닫혔는가?
    elif cur == ")" or cur == "]":
        # closed = True
        if i >= len(text)-1:  # 마지막 라운드면 그냥 ) 하고 끝내기
            answer.append(")")
        else:  # 마지막 전까지만 검사
            next = text[i+1]
            # 연속으로 닫히느냐?
            if next == ")" or next == "]":
                answer.append(")")
            # 다음엔 열리느냐?
            elif next == "(" or next == "[":
                answer.append(")+")

    # step 2 : 숫자 삽입
    if cur == "(":
        answer.append("(2")
    elif cur == "[":
        answer.append("(3")

    print("i = {}, cur = {}, prev = {}, stack = ".format(
        i, cur, prev), stack, "answer = ", answer)

answer.append(")")
print(answer)
res = "".join(answer)
print(res)
print(eval(res))

# ( ( ) [ [ ]          ] ) (      [    ] )
# (2 *( (2 )+ (3 *( (3 ) ) )+ (2 *( (3 ) ) 끝)

# 상당한 뻘짓으로 시간 날려먹음
