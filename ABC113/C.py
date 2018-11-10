def printNum(n):
    s = str(n)
    return("0"*(6-len(s))+s)
N,M=map(int,input().split())
id = [[] for i in range(N)]
for i in range(M):
    P,Y = map(int,input().split())
    id[P-1].append((Y,i))
for p in range(N):
    id[p].sort(key=lambda x: x[0])
answerlist = []
for p in range(N):
    for j in range(len(id[p])):
        year,i = id[p][j]
        answerlist.append((i,printNum(p+1)+printNum(j+1)))
answerlist.sort(key=lambda x: x[0])
for i,ans in answerlist:
    print(ans)
