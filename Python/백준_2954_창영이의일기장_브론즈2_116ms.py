import sys
input = sys.stdin.readline

otext = input()
rtext = ''
moum = ['a', 'e', 'i', 'o', 'u']

i = 0
while i < len(otext):
    if otext[i] in moum:
        if otext[i:i+3] == 'apa':
            rtext += 'a'
        elif otext[i:i+3] == 'epe':
            rtext += 'e'
        elif otext[i:i+3] == 'ipi':
            rtext += 'i'
        elif otext[i:i+3] == 'opo':
            rtext += 'o'
        elif otext[i:i+3] == 'upu':
            rtext += 'u'
        i += 3
    else:
        rtext += otext[i]
        i += 1

print(rtext)

# 이걸 정규표현식으로 어케푸냐..
