TC = int(input())
checker = TC
for _ in range(TC):
    map = []
    st = input()
    for i in range(len(st)):
      # i 가 처음 왔으면 추가
      # i 가 이미 있으면?
      # 이전거 확인해서 같으면 일단 추가 ㄴ
      # 이전거 확인해서 다르면 얜 그룹단어가 아님.
        if st[i] in map:
            if st[i] == st[i-1]:
                pass
            else:
                checker -= 1
                break
        else:
            map.append(st[i])
print(checker)
