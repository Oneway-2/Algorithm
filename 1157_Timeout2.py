def Get_count(word):
    count_list = []
    for i in word:
        count_list.append(word.count(i))
    return count_list

def Get_maximum(count_list):
    count_max = max(count_list)
    return count_max

word = list(input().upper())

count_list = Get_count(word)
count_max = Get_maximum(count_list)
greatest_text = word[count_list.index(count_max)] 

for i in range(count_max):
    word.remove(greatest_text)

if not word:
    print(greatest_text)
else:    
    count_list2 = Get_count(word)
    count_max2 = Get_maximum(count_list2)

    if count_max == count_max2:
        print("?")
    else:
        print(greatest_text)