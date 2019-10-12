answer = 0
S = input()
answer = 0
anyZero = False
for i in range(len(S)):
    if i%2 == 0:
        num = int(S[i])
        if num == 0:
            anyZero = True
    else:
        if S[i] == "+":
            if not anyZero:
                answer += 1
            anyZero = False
if not anyZero:
    answer += 1
print(answer)