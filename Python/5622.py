# dial

def Counting(dial):
    if ("A" <= dial) and (dial <= 'C'):
        return 1
    elif ("D" <= dial) and (dial <= 'F'):
        return 2
    elif ("G" <= dial) and (dial <= 'I'):
        return 3
    elif ("J" <= dial) and (dial <= 'L'):
        return 4
    elif ("M" <= dial) and (dial <= 'O'):
        return 5
    elif ("P" <= dial) and (dial <= 'S'):
        return 6
    elif ("T" <= dial) and (dial <= 'V'):
        return 7
    elif ("W" <= dial) and (dial <= 'Z'):
        return 8

dial = input()
time = 0
for i in dial:
    time += 2
    time += Counting(i)
print(time)