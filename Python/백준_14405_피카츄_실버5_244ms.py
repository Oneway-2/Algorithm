import sys
import re
input = sys.stdin.readline
text = input().rstrip()
p = re.compile("(pi|ka|chu)+")
result = p.fullmatch(text)
print("NO" if result == None else "YES")
