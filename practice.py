dicts = {0:1, 1:1, 2:2, 3:3, 4:4, 5:5, 6:5, 7:6, 8:7, 9:8, 10:9}
print(dicts)

for i in range(len(dicts)):
    for key, value in dicts.items():
        if value == i:
            print("i == {}, key == {}".format(i, key))