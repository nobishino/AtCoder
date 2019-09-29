N,M=map(int,input().split())
invs = []
for _ in range(M):
    L,R = map(int,input().split())
    invs.append((L,R-1)) #R<N
invs.sort(key=lambda inv: inv[0])
x = N
ans = 0
#walls = []
for (a,b) in invs:
    if a > x:
        ans += 1
        #walls.append(x)
        x = b
    else:
        x = min(x,b)
#walls.append(x)
ans += 1
#print(walls)
print(ans)