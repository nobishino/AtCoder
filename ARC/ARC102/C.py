N,K=map(int,input().split())
r = N//K
q = N%K
if K%2 == 0:
    if K//2 <= q:
        ans = pow(r,3) + pow(r+1,3)
    else:
        ans = pow(r,3) + pow(r,3)
else:
    ans = pow(r,3)
print(ans)