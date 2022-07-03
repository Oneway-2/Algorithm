import sys
input = sys.stdin.readline
mmap = [list(map(int, input().split())) for i in range(19)]
dr = [-1, 0, 1, 1]
dc = [1, 1, 1, 0]

for r in range(19):
    for c in range(19):
        if mmap[r][c] != 0:
            winner = mmap[r][c]

            for k in range(4):
                nr = r + dr[k]
                nc = c + dc[k]
                cnt = 1

                while 0 <= nr < 19 and 0 <= nc < 19 and mmap[nr][nc] == winner:
                    cnt += 1

                    if cnt == 5:
                        # 육목 체크
                        if 0 <= r - dr[k] < 19 and 0 <= c - dc[k] < 19 and mmap[r-dr[k]][c-dc[k]] == winner:
                            break
                        if 0 <= nr + dr[k] < 19 and 0 <= nc + dc[k] < 19 and mmap[nr+dr[k]][nc+dc[k]] == winner:
                            break

                        print(winner)
                        print(r + 1, c + 1)
                        exit(0)

                    nr += dr[k]
                    nc += dc[k]

print(0)

# 육목 체크를 안해줘서 계속 틀렸었다..
