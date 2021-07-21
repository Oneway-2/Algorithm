# DFS, BFS

n, m, v = map(int, input().split())
link_list = ()
for i in range(m):
    a, b = map(int, input().split())
    link_list.append((a,b))
print(link_list)

