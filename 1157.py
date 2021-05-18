word = input().upper()
spell_count = [0] * 26

for i in range(26):
    spell_count[i] = word.count(chr(i+65))
    
if spell_count.count(max(spell_count)) >= 2: 
    print("?")
else:
    print(chr(spell_count.index(max(spell_count))+65))