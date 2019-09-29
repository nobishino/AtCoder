MOD = 1000000007
H,W,K=map(int,input().split())
##Precalculation            
num = [[0 for _ in range(W)] for _ in range(W)]
for value in range(2**(W-1)):
    bit = [False for _ in range(W-1)]
    for d in range(W-1):
        bit[d] = (2**d & value) > 0
    duplicate = False
    for d in range(1,W-1):
        if bit[d] and bit[d-1]:
            duplicate = True
            break
    if duplicate:
        continue
    ##No Duplicate Assured
    for x in range(W):
        num[x][x] += 1
    for d in range(W-1):
        if bit[d]:
            num[d][d+1] += 1
            num[d+1][d] += 1
            num[d][d] -= 1
            num[d+1][d+1] -= 1
##Time to Dynamic Programming YEAHHHHHH##
dp = [[0 for _ in range(W)] for _ in range(H+1)]
dp[0][0] = 1
for h in range(1,H+1):
    for k in range(W):
        for j in range(W):
            dp[h][k] += (dp[h-1][j]*num[j][k])%MOD
            dp[h][k] %= MOD
print(dp[H][K-1])