N,K=map(int,input().split())
x=list(map(int,input().split()))
index = 0
ans = 10**9
while index + K - 1 < N:
    start = x[index]
    end = x[index + K - 1]
    if start < 0:
        ans = min(ans,abs(end-start)+abs(start))
        ans = min(ans,abs(end-start)+abs(end))
    else:
        ans = min(ans,end)
    index += 1
print(ans)