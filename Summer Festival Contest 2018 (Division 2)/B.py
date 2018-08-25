L = int(input())
S=input()

x = -1
y = L
for i in range(L):
    if S[i] == "D":
        x = i
    if S[i] == "K" and y == L:
        y = i
if x > y:
    ans = 0
else:
    ans = y-x
print(ans)
