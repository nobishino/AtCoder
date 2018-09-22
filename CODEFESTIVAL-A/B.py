N,M,A,B=map(int,input().split())
isa=[False for _ in range(N)]
for _ in range(M):
    L,R = map(int,input().split())
    for i in range(L-1,R):
        isa[i] = True
ans = 0
for i in range(N):
    if isa[i]:
        ans += A
    else:
        ans += B
print(ans)