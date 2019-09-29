S = input()
T = input()
L = len(S)
dicS = {}
dicT = {}
ans = "Yes"
for i in range(L):
    if S[i] not in dicS:
        dicS[S[i]] = T[i]
    else:
        if T[i] != dicS[S[i]]:
            ans ="No"
    if T[i] not in dicT:
        dicT[T[i]] = S[i]
    else:
        if S[i] != dicT[T[i]]:
            ans = "No"
print(ans)
