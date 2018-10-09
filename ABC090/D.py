N,K = map(int,input().split())
ans = 0
for b in range(K+1,N+1):
    x1,y1 = divmod(N-K,b)
    x2,y2 = divmod(N-b+1,b)
    if x1 == x2:
        ans += (x1+1)*(y1-y2+1)
    elif x1 == x2+1:
        ans += (x1+1)*(y1+1)+(x2+1)*(b-y2+1)
    else:
        ans += (x1+1)*(y1+1)+(x2+1)*(b-y2+1)
        ans += b*(x1+x2+2)*(x1-x2-1)//2
print(ans)