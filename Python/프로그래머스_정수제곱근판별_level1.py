def solution(n):
    answer = 0
    root = n ** (1/2)
    if root == int(root):  # 제곱근임
        newRoot = root + 1
        answer = newRoot ** 2
    else:
        answer = -1

    return answer
