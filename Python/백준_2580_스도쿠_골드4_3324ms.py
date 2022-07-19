import sys
input = sys.stdin.readline
sudoku = []
zeros = []
for i in range(9):
    sudoku.append(list(map(int, input().rstrip().split())))

zeros = [(i, j) for i in range(9) for j in range(9) if sudoku[i][j] == 0]


def checkRow(x, a):
    for i in range(9):
        if a == sudoku[x][i]:
            return False
    return True


def checkCol(y, a):
    for i in range(9):
        if a == sudoku[i][y]:
            return False
    return True


def checkRect(x, y, a):
    nx = x // 3 * 3
    ny = y // 3 * 3
    for i in range(3):
        for j in range(3):
            if a == sudoku[nx+i][ny+j]:
                return False
    return True


def dfs(idx):
    if idx == len(zeros):
        for i in range(9):
            print(*sudoku[i])
        exit(0)

    for i in range(1, 10):
        x = zeros[idx][0]
        y = zeros[idx][1]

        if checkRow(x, i) and checkCol(y, i) and checkRect(x, y, i):
            sudoku[x][y] = i
            dfs(idx + 1)
            sudoku[x][y] = 0


dfs(0)
