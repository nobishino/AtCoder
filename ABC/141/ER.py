import math
MOD = pow(2,61) - 1
def charToNum(char):
    return ord(char) - 96

def check(string,subLen):
    if subLen == 0: return True
    #長さsubLenの部分文字列すべてについてローリングハッシュを計算して、
    #一致するものがあるかどうかを計算する。
    # setOfRollingHash = set()
    dictOfRollingHash = {}
    totalLen = len(string)
    h = 0
    b = 1
    for i in range(subLen):
        c = string[subLen - 1 - i]
        h += charToNum(c) * b
        b *= 27
        b %= MOD
    h %= MOD
    dictOfRollingHash[h] = 0
    maxBase = pow(27,subLen - 1,MOD) 
    for i in range(1,totalLen - subLen + 1):
        h -= maxBase * charToNum(string[i - 1])
        h *= 27
        h += charToNum(string[i + subLen - 1])
        h %= MOD
        if h in dictOfRollingHash:
            if i - dictOfRollingHash[h] >= subLen:
                return True
        else:
            dictOfRollingHash[h] = i
    return False

N = int(input())
S = input()
ok = 0
ng = N + 1
while abs(ok-ng) > 1:
    mid = (ok+ng)//2
    if check(S,mid):
        ok = mid
    else:
        ng = mid
print(ok)