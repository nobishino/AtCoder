S = input()
L = len(S)
C = "?ABC"
mod = 10**9 + 7
dp = [[1,0,0,0] for _ in range(L+1)] 
#dp[i][j] = i文字目までを使ってj番目まで丸を付ける方法
for i in range(1,L+1):
    for j in range(1,4):
        if S[i-1] == C[j]:
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
        elif S[i-1] == "?":
            dp[i][j] = dp[i-1][j-1] + 3*dp[i-1][j]
        else:
            dp[i][j] = dp[i-1][j]
print(dp[L][3]%mod)
