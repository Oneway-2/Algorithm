from collections import deque


def solution(places):
    answer = []
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    def checkbfs(r, c, step):
        queue = deque()
        visited = [[False for i in range(5)] for i in range(5)]
        queue.append((r, c, step))
        visited[r][c] = True
        while queue:
            ar, ac, sstep = queue.popleft()
            for i in range(4):
                nr = ar + dr[i]
                nc = ac + dc[i]
                if 0 <= nr < 5 and 0 <= nc < 5 and sstep < 2 and plist[nr][nc] != 'X' and visited[nr][nc] == False:
                    if plist[nr][nc] == 'P':
                        # 안지켰네
                        return False
                    elif plist[nr][nc] == 'O':
                        visited[nr][nc] = True
                        queue.append((nr, nc, sstep + 1))
        # 여기까지 온거면 지킨거임
        return True

    for p in places:
        plist = []
        for j in p:
            plist.append(j)
        isDistanced = True

        for r in range(5):
            for c in range(5):
                # P 찾음
                if plist[r][c] == 'P':
                    if checkbfs(r, c, 0) == False:
                        isDistanced = False
                        break
            if isDistanced == False:
                break
        if isDistanced == False:
            answer.append(0)
        else:
            answer.append(1)

    return answer
