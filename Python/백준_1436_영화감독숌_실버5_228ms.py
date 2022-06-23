N = int(input())
cnt = 1
idx = 666
while cnt != N:
    idx += 1
    if str(idx).find("666") != -1:
        cnt += 1
print(idx)
