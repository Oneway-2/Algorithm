import sys
import re
input = sys.stdin.readline

sound = input().rstrip()
regex = '((100+1+|01)+)'
p = re.compile(regex)
result = p.fullmatch(sound)
print("NOISE" if result == None else "SUBMARINE")

# fullmatch를 이용한 해결방법 학습
