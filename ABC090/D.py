ans = 0
N,K = map(int,input().split())
for b in range(K+1,N+1):
    x1,y1 = divmod(N-K,b)
    x2,y2 = divmod(N-b+1,b)
    if x1==x2:
        ans += (x1+1)*(y1-y2+1)
    else:
        ans += (x1+1)*(y1+1) + (x2+1)*(b-y2)+b*(x1+x2+2)*(x1-x2-1)//2
if K == 0:
    print(N*N)
else:
    print(ans)