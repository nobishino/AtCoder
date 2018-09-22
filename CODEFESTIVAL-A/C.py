def capacity(k):
    k = int(k)
    if k==0:
        return 0
    else:
        return(1+capacity(k//2))
N,K = map(int,input().split())
caps = list(map(capacity,input().split()))
sumcap = sum(caps)
req = min(K,sumcap)
dp = [[1 for _ in range(N+1)] for _ in range(req+2)]
for n in range(N+1):
    dp[0][n] = 0
#dp[c+1][n] はcの荷物をnまでのパックに詰める方法の数のc=0からcまでの累積和
for n in range(1,N+1):
    for c2 in range(1,req+1):
        c=c2+1
        lowb = max(0,c-caps[n-1]-1)
        dp[c][n] = dp[c][n-1] - dp[lowb][n-1] + dp[c-1][n]
print("capacities")
print(caps)
print("dptable")
for raw in dp:
    print(raw)
print("answer")
ans1 = dp[req+1][N]
for i in range(N):
    caps[i] = max(0,caps[i]-1)
print(caps)

dp = [[1 for _ in range(N+1)] for _ in range(req+2)]
for n in range(N+1):
    dp[0][n] = 0
    
for n in range(1,N+1):
    for c2 in range(1,req+1):
        c=c2+1
        lowb = max(0,c-caps[n-1]-1)
        dp[c][n] = dp[c][n-1] - dp[lowb][n-1] + dp[c-1][n]

ans2 = dp[req+1][N]
print(ans1-ans2)