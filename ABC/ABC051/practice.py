N,M = map(int,input().split())
link = [{} for _ in range(N+1)]
for _ in range(M):
    v,w,c = map(int,input().split())
    link[v][w] = c
    link[w][v] = c
INF = 10000000
dp = [[[INF for _ in range(N+1)] for _ in range(N+1)] for _ in range(N+1)]
for i in range(N+1):
    for j in range(N+1):
        if w in link[v]:
            dp[0][i][j] = link[v][w]
for k in range(1,N+1):
    for i in range(N+1):
        for j in range(N+1):
            dp[k][i][j] = min(dp[k-1][i][j],dp[k-1][i][k]+dp[k-1][k][j])
for i in range(N+1):
    print(dp[N][i])

