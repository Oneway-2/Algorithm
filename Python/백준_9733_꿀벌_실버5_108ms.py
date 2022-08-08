import sys
input = sys.stdin.readlines
graph = {"Re": 0, "Pt": 0, "Cc": 0, "Ea": 0, "Tb": 0, "Cm": 0, "Ex": 0}
cnt = 0
lines = input()
for line in lines:
    txt = list(line.split())
    for i in txt:
        if i in graph.keys():
            graph[i] += 1
        cnt += 1

print("Re {} {:.2f}".format(graph["Re"], graph["Re"] / cnt))
print("Pt {} {:.2f}".format(graph["Pt"], graph["Pt"] / cnt))
print("Cc {} {:.2f}".format(graph["Cc"], graph["Cc"] / cnt))
print("Ea {} {:.2f}".format(graph["Ea"], graph["Ea"] / cnt))
print("Tb {} {:.2f}".format(graph["Tb"], graph["Tb"] / cnt))
print("Cm {} {:.2f}".format(graph["Cm"], graph["Cm"] / cnt))
print("Ex {} {:.2f}".format(graph["Ex"], graph["Ex"] / cnt))
print("Total {} 1.00".format(cnt))

# 배운점
# dict 문법 / sys.stdin.readlines 사용법 / format 사용한 소수점 표현법
