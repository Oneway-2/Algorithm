def solution(board, moves):
    answer = 0
    bucket = [-1]
    height = len(board)

    for i in moves:
        pos = i-1
        h = 0
        while True:
            if board[h][pos] != 0:
                # 상자 안에 두개 연속으로 박혔는지 체크
                if bucket[-1] == board[h][pos]:
                    bucket.pop()
                    answer += 2
                else:
                    # 연속이 아니면 얌전히 넣음
                    bucket.append(board[h][pos])
                board[h][pos] = 0
                break
            else:
                h += 1
                if h > height-1:
                    break

    return answer

# bucket이 비어있을 때 bucket[-1]을 탐색하면 out of index 뜨는걸 모르고 계속 board에서 뜨는 줄 알고 시간낭비했다.
