N=int(input())
said = set()
char = ""
flag = True
for i in range(N):
    word = input()
    if char != "" and word[0] != char:
        flag = False
    if word in said:
        flag = False
    said.add(word)
    char=word[len(word)-1]
if flag:
    print("Yes")
else:
    print("No")


