H,W=map(int,input().split())
list = []
def isAllWhite(raw):
    for char in raw:
        if char != ".":
            return(False)
    return(True)

for i in range(H):
    raw = input()
    if isAllWhite(raw):
        continue
    else:
        list.append(raw)

def isColWhite(list,col):
    L = len(list)
    for i in range(L):
        if list[i][col] != ".":
            return(False)
    return(True)

ans = [[] for _ in range(len(list))]
for j in range(len(list[0])):
    if isColWhite(list,j):
        continue
    else:
        for i in range(len(ans)):
            ans[i].append(list[i][j])
for raw in ans:
    print("".join(raw))