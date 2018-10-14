N,X=map(int,input().split())
bmax=0
amax=0
ans = 0
for _ in range(N):
    a,b=map(int,input().split())
    if b > bmax:
        bmax = b
    ans += a*b
ans += X * bmax
print(ans)