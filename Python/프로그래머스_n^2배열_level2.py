def solution(n, left, right):
    answer = []
    for i in range(left, right+1):
        row, col = divmod(i, n)
        num = row if row >= col else col
        # print("i = {}, row = {}, col = {}, num = {}".format(i, row, col, num))
        answer.append(num + 1)
    return answer

    # dr = [1, 0, 1]
    # dc = [0, 1, 1]
    # graph = [[0 for i in range(n)] for i in range(n)]
    # queue = deque()
    # queue.append((0, 0, 1))
    # graph[0][0] = 1
    # while queue:
    #     r, c, num = queue.popleft()
    #     for i in range(3):
    #         nr = r + dr[i]
    #         nc = c + dc[i]
    #         if 0 <= nr < n and 0 <= nc < n and graph[nr][nc] == 0:
    #             queue.append((nr, nc, num + 1))
    #             graph[nr][nc] = num + 1

    # idx = 0
    # answer = []
    # for i in range(n):
    #     for j in range(n):
    #         if left <= idx <= right:
    #             answer.append(graph[i][j])
    #         idx += 1
    #         if idx > right:
    #             return answer
solution(3, 2, 5)
solution(4, 7, 14)

# n이 10^7까지 갈 수 있는걸 보고 빨리 이거 배열로 푸는거 아닌걸 알았어야 했다.
