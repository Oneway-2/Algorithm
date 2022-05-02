import sys
I = sys.stdin.readline
n, m, s = map(int, I().split())
g = [[]*(n+1) for _ in range(n+1)]


def dfs(f):
    v = [True]*(n+1)
    q = [f]
    ddd = []
    while q:
        i = q.pop()
        if v[i]:
            v[i] = False
            ddd += [i]
            q += reversed(g[i])
    return ddd


def bfs(f):
    v = [True] * (n+1)
    v[f] = False
    bbb = [f]
    q = []
    q.append(f)
    while q:
        f = q.pop(0)
        for i in g[f]:
            if v[i]:
                bbb.append(i)
                q += [i]
                v[i] = False
    return bbb


for i in range(m):
    a, b = map(int, I().split())
    g[a] += [b]
    g[b] += [a]

for i in range(n+1):
    g[i].sort()

print(*dfs(s))
print(*bfs(s))
