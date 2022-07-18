import sys
input = sys.stdin.readline
sudoku = []
for i in range(9):
    sudoku.append(list(map(int, input().split())))

zeros = [(i, j) for i in range(9) for j in range(9) if sudoku[i][j] == 0]

print(sudoku)


def fillSudoku():
    nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]


fillSudoku()
