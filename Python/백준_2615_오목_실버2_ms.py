import sys
input = sys.stdin.readline
mmap = []
for i in range(19):
    mmap.append(list(map(int, input().split())))

dr = [0, 1, 1, 1]
dc = [1, 1, 0, -1]
winner = 0
wr = 0
wc = 0

for r in range(19):
    for c in range(19):
        # print(j, end=" ")
        # print("r, c : ", r, c, "map[{}][{}] = {}".format(r, c, mmap[r][c]))
        if mmap[r][c] == 1:
            wr, wc = r, c
            for k in range(5):
                nr = dr[k]*(k+1) + r
                nc = dr[k]*(k+1) + c
                if 0 > nr or nr >= 19 or 0 > nc or nr >= 19:
                    # 바깥으로 나갔음
                    break
                wr = min(nr, wr)
                wc = min(nc, wc)
                if mmap[nr][nc] != 1:
                    # 중간에 끊김
                    break
                else:
                    # 한번도 중간에 끊김 없이 4까지 간다는건 오목 완성이란뜻
                    winner = 1
        elif mmap[r][c] == 2:
            wr, wc = r, c
            for k in range(1, 5):
                nr = dr[k]*(k+1) + r
                nc = dr[k]*(k+1) + c
                if 0 > nr or nr >= 19 or 0 > nc or nr >= 19:
                    # 바깥으로 나갔음
                    break
                wr = min(nr, wr)
                wc = min(nc, wc)
                if mmap[nr][nc] != 2:
                    # 중간에 끊김
                    break
                else:
                    # 한번도 중간에 끊김 없이 4까지 간다는건 오목 완성이란뜻
                    winner = 2
        else:
            continue


if winner == 1 or winner == 2:
    print(winner)
    print(wr, wc)
else:
    print(winner)
