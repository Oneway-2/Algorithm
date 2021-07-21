# Croatia alphabet

a = input()
text = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
count = len(a)
for i in text:
    count -= a.count(i)
print(count)