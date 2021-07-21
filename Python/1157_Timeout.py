word = list(input().upper())
dic = dict()

for i in range(len(word)):
    dic[word[i]] = word.count(word[i])

dic_values = dic.values()
dic_max = max(dic_values)
duplicate_exist = list(dic_values).count(dic_max)

def Get_key(val):
    for key, value in dic.items():
        if val == value:
            return key
    return "?"

if duplicate_exist > 1:
    print("?")
elif duplicate_exist == 1:
    print(Get_key(dic_max))