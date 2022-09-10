def solution(n):
    strn = str(n)
    nlist = []
    for i in strn:
        nlist.append(i)
    nlist.sort(reverse = True)
    strAnswer = ''
    for i in nlist:
        strAnswer += i
    print(strAnswer)
    answer = int(strAnswer)
    return answer