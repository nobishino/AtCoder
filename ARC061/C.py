answer = 0
S = input()
L = len(S)
for bit in range(2**(L-1)):
    string = ""
    for m in range(L-1):
        if bit & 2**m:
            string += S[m]
            answer += int(string)
            string = ""
        else:
            string += S[m]
    string += S[L-1]
    answer += int(string)
print(answer)