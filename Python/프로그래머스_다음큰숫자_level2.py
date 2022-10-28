def solution(n):
    ntobin = "{0:b}".format(n)
    ntobin_count = ntobin.count("1")
    nextnum = n + 1
    # print("ntobin = {}, ntobin_count = {}".format(ntobin, ntobin_count))
    while True:
        nexttobin = "{0:b}".format(nextnum)
        nexttobin_count = nexttobin.count("1")
        if nexttobin_count == ntobin_count:
            # print("답은 ", int(nexttobin, 2))
            return int(nexttobin, 2)
        else:
            nextnum += 1


solution(78)
solution(15)

# 10진수 -> 2진수 / 2진수 -> 10진수 변환법 암기할 것
