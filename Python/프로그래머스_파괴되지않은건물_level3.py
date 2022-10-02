def solution(board, skill):
    # type, r1, c1, r2, c2, degree (type 1 = 공격, type 2 = 회복)
    rlen, clen = len(board), len(board[0])
    tmp = [[0 for i in range(clen+1)] for i in range(rlen+1)]

    for sk in skill:
        type, r1, c1, r2, c2, degree = map(int, sk)
        tmp[r1][c1] += degree if type == 2 else -degree
        tmp[r1][c2 + 1] += -degree if type == 2 else degree
        tmp[r2 + 1][c1] += -degree if type == 2 else degree
        tmp[r2 + 1][c2 + 1] += degree if type == 2 else -degree

    # 행 누적합
    for r in range(rlen):
        for c in range(clen):
            tmp[r][c+1] += tmp[r][c]
    # 열 누적합
    for r in range(rlen):
        for c in range(clen):
            tmp[r+1][c] += tmp[r][c]

    answer = 0
    for r in range(rlen):
        for c in range(clen):
            board[r][c] += tmp[r][c]
            if board[r][c] >= 1:
                answer += 1

    return answer

# 단순히 2중 for문으로 풀면 시간초과가 난다.
# tmp 배열에 증가시켜야 할 위치와 값을 기록만 해준 뒤, 누적합하여 한 번의 2중 for문으로 board에 더한다.
