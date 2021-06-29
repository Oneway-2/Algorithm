# Alex Origami Squares

h, w = map(int, input().split())
[greater, less] = [h, w] if h > w else [w, h]
g = greater/3
if g >= less:
    # print("한쪽이 압도적으로 김")
    print(less)
else:
    l = less/2
    if g >= l:
        # print("일렬로 3개 넣기 가능함")
        print(g)
    else:
        # print("아래 둘, 위에 하나로 넣어야함")
        print(l)