def maxLengthBeginningFrom(i, string):
    ans = 0
    substring = string[i:]
    zArray = efficientZ(substring)
    for j in range(len(zArray)):
        ans = max(ans, min(j, zArray[j]))
    return ans

def efficientZ(string):
    """
    引数: string
    戻り値: 数値からなる配列。0番目の値は0．空文字列に対しては[]を返す。
    >>> efficientZ("ababa")
    [0,0,3,0,1]
    >>> efficientZ("aaaaa")
    [0,4,3,2,1]
    """
    length = len(string)
    Z = [0 for _ in range(length)]
    left = 0
    right = 0
    for i in range(1, length):
        if i >= right: 
            j = 0
            while i + j < length:
                if (string[j] == string[i + j]):
                    j += 1
                else:
                    break
            Z[i] = j
            left = i
            right = i + j
        else:
            correspondingValue = Z[i - left]
            if i + correspondingValue < right:
                Z[i] = correspondingValue
            else:
                j = right - i
                while i + j < length:
                    if string[i + j] == string[j]:
                        j += 1
                    else:
                        break
                Z[i] = j
                left = i
                right = i + j
    return Z 

N = int(input())
S = input()
ans = 0
for i in range(len(S)):
    ans = max(ans,maxLengthBeginningFrom(i, S))
print(ans)

