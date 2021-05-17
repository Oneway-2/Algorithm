word = list(input().upper())
spell_count = [0] * 26

for j in range(len(word)):
    for i in range(26):
        if chr(i+65) == word[j]:
            spell_count[i] += 1
            break

if spell_count.count(max(spell_count)) >= 2: 
    print("?")
else:
    print(chr(spell_count.index(max(spell_count))+65))