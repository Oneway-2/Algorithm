# student_tuples = [
#   ('john', 'A', 15),
#   ('jane', 'B', 12),
#   ('dave', 'B', 10),
# ]

# print(student_tuples)
# student_tuples.sort(reverse=True, key=lambda student: student[2])
# print(student_tuples)

# data = [('red', 1), ('blue', 1), ('red', 2), ('blue', 2)]
# print(data)
# data.sort(reverse=True, key=lambda a: a[0])
# print(data)

# for i in enumerate(data):
#   print(i)

# print("I eat %d apples" % 3)
# print("{0:!^20}".format("hi"))
# print("\n".join("mushmom").split("\n"))
# print("mushmom".upper())

# a = [(1,2), (3,4), (5,6)]
# for (first, last) in a:
#   print(first, last)

# asd = list()
# asd.append(["frodo", "neo"])
# print(["frodo", "neo"] in asd)

# a = {"muzi": "frodo"}
# print(a)
# a["muzi"] = "neo"
# print(a)

# mylist = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
# print(mylist)
# new_list = list(map(list, zip(*mylist)))
# print(new_list)


# def cs(s):
#     _c = ""
#     cnt = 0
#     result = ""
#     for c in s:
#         if c != _c:
#             _c = c
#             if cnt:
#                 result += str(cnt)
#             result += c
#             cnt = 1
#         else:
#             cnt += 1
#     if cnt:
#         result += str(cnt)
#     return result


# print(cs("aaabbcccccccca"))

# nlist = [[0 for i in range(10)] for i in range(10)]
# plist = [a[:] for a in nlist]

# print(nlist)
# print(plist)

# nlist = ["a", "b", "c"]
# print(nlist.index("b"))
# print(nlist.index("c"))

# test = [[0] * 3 for i in range(5)]
# print(test)

# q = dict()
# q[1] = 6
# q[2] = 7
# q[3] = 8
# print(q)
# print(1 in q)
# print(6 in q)

# import heapq
# heap = []
# heapq.heappush(heap, 1)
# heap.append(2)
# heap.append(6)
# heapq.heappush(heap, 3)
# print(heap)

# form = []
# # for i in "(2*((2)+(3*(3))))+(2*((3)))":
# # for i in "2*((2)+(3*((3)))+(2*((3)))":
# for i in "2*((2))+(3*((3))))+(2*((3)))":
#     form.append(i)
# print(form)
# formula = "".join(form)
# print(formula)
# # formula = "(2*((2)+(3*(3))))+(2*((3)))"
# print(eval(formula))
# form.clear()
# print(form)
# form.append(0)
# print(form)

# group = False
# print(group)
# group = not group
# print(group)
# group = not group
# print(group)

# total = (1 << 4) - 1
# newtotal = 0
# obj = 1 << 1
# # print(bin(total & obj))
# # print(bin(total | obj))
# target = 2
# newobj = 1 << (target-1)
# print(total & newobj == target)
# print(newtotal & newobj == target)
# print(int(0b1000000000))
# # a = (1 << 20) - 1
# a = 0
# b = 1 << 10-1
# print(a, bin(a))
# print(b, bin(b))
# print(a & b)

# s = set()
# s = set([i for i in range(1, 21)])
# print(3 in s)
# s.discard(3)
# print(3 in s)

# hi = (3, 5, [1, 2, 3, 4, 5])
# print(hi)
# print(hi[0])
# print(hi[1])
# print(hi[2])

# r = dict()
# r["hi"] = []
# r["hi"].append("bye")
# r["hi"].append("yo")
# r["hello"] = 0
# r["hello"] += 1
# r["hello"] += 1
# r["hello"] += 1
# print(r)

# print(r["hi"] in "bye")

# import collections
# temp = ["a", "b", "c", "d"]
# temp2 = ["a", "b", "c"]
# t = collections.Counter(temp)
# t2 = collections.Counter(temp2)
# print(t)
# print(t2)
# print(t - t2)

# thash = hash(10)
# thash = hash(20)
# print(hash("11"))
# print(hash("12"))
# print(hash("11"))

# _list = ["hiyo", "my name is hi", "in the ha"]
# for sentence in _list:
#     idx = 0
#     while ' ' in sentence:
#         sentence = sentence.replace(' ', '', 1)
#         print(idx, sentence)
#         idx += 1

# from queue import PriorityQueue
# import heapq
# text = "HIYO"
# text2 = "hi.yo"
# nlist = ['a', 'b', 'c']
# print("HI" in text)
# print(text2.replace('.', *nlist))
# for s in text:
#     if s.isupper():
#         print(s)
#         s = s.lower()
#         print(s)

# que = PriorityQueue()
# que.put(3)
# que.put(1)
# que.put(5)
# print(que)

# import heapq
# heap = [1, 9, 2, 8, 3, 7, 4, 6, 5]
# print(heap)
# heapq.heapify(heap)
# print(heap)
# print(heap.index(9))
# try:
#     print(heap.index(100))
# except:
#     print("그딴건없어요")

# import re
# # txt = "How do you do?&"
# txt = '''
# hihi
# mush
# 010-2424-1212
# 010-1234-2345
# '''
# # r = re.compile("[owy][owy]")
# # r = re.compile("[dH].")
# r = re.compile("/D{3}-/D{4}-/D{4}")
# result = r.findall(txt)
# print(result)

n = 2
T = 0
for num in range(0, 0):  # a ~ b-1
    T = T + num
print(T)

# n / T
# 0 / 0 = 0 + 0
# 0 / 0 = 0 + 1

# dicts = {}
# print(dicts)
# dicts['A'] = 'abcd'
# print(dicts)  # 'A' : 'abcd'
# print(dicts['A'])
