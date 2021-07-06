# 비밀편지

def Check(a):
    if a=="000000" or a=="100000" or a=="010000" or a=="001000" or a=="000100" or a=="000010" or a=="000001":
        return "A"
    elif a=="001111" or a=="001110" or a=="001101" or a=="001011" or a=="000111" or a=="101111" or a=="011111":
        return "B"
    elif a=="010011" or a=="010010" or a=="010001" or a=="000011" or a=="110011" or a=="011011" or a=="010111":
        return "C"
    elif a=="011100" or a=="011000" or a=="010100" or a=="001100" or a=="111100" or a=="011110" or a=="011101":
        return "D"
    elif a=="100110" or a=="100100" or a=="100010" or a=="000110" or a=="110110" or a=="101110" or a=="100111":
        return "E"
    elif a=="101001" or a=="101000" or a=="100001" or a=="001001" or a=="111001" or a=="101101" or a=="101011":
        return "F"
    elif a=="110101" or a=="110100" or a=="110001" or a=="100101" or a=="010101" or a=="111101" or a=="110111":
        return "G"
    elif a=="111010" or a=="111000" or a=="110010" or a=="101010" or a=="011010" or a=="111110" or a=="111011":
        return "H"
    else:
        return "STOP"

n = int(input())
letter = input()
real_text = []
order = 1
flag = True
for i in range(0, n*6, 6):
    a = letter[i:i+6]
    text = Check(a)
    if text == "STOP":
        # print("{}을 못알아먹겠군".format(a))
        flag = False
        break
    real_text.append(text)
    # print(real_text)
    order += 1

if flag == False:
    print(order)
else:
    print("".join(real_text))