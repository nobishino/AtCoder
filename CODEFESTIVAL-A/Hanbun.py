MOD = 10**9 + 7
def capacity(k):
    k = int(k)
    if k==0:
        return 0
    else:
        return(1+capacity(k//2))
N,K = map(int,input().split())
caps = list(map(capacity,input().split()))
sumcaps = sum(caps)
K = min(K,sumcaps)
dp =[[[0 for _ in range(N+1)] for _ in range(K+2)] for _ in range(2)]
flag = False
for n in range(1,N+1):
    if caps[n-1] == 0:
        flag = True
    if flag:
        dp[1][1][n] = 1
        dp[0][1][n] = 0
    else:
        dp[1][1][n] = 0
        dp[0][1][n] = 1
for c in range(K+1):
    cc = c+1
    dp[0][cc][0] = 1
for n in range(1,N+1):
    for c in range(1,K+1):
        cc = c+1
        if caps[n-1] > 0:
            v = max(cc - caps[n-1],0)
            dp[0][cc][n] = dp[0][cc][n-1] - dp[0][v][n-1]+ dp[0][cc-1][n]
            w = max(v-1,0)
            dp[1][cc][n] = dp[0][v][n-1]-dp[0][w][n-1] + dp[1][cc][n-1]-dp[1][w][n-1]+ dp[1][cc-1][n]
        else:
            dp[0][cc][n] = dp[0][cc-1][n]
            dp[1][cc][n] = dp[0][cc][n-1]-dp[0][cc-1][n-1] + dp[1][cc][n-1]-dp[1][cc-1][n-1] + dp[1][cc-1][n]
        dp[0][cc][n] = dp[0][cc][n] % MOD
        dp[1][cc][n] = dp[1][cc][n] % MOD
answer = dp[1][K+1][N] + dp[0][K+1][N] - dp[0][K][N]
answer = answer % MOD
print(answer)