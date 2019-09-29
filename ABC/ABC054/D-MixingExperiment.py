# https://beta.atcoder.jp/contests/abc054/tasks/abc054_d

N,Ma,Mb = map(int,input().split())
qa=Ma
qb=Mb
candidates = []
while qa <= N*10 and qb <= N*10:
    candidates.append((qa,qb))
    qa += Ma
    qb += Mb
a = []
b = []
c = []
for _ in range(N):
    A,B,C = map(int,input().split())
    a.append(A)
    b.append(B)
    c.append(C)
#DP
INF = 10**8
dp = [[[INF for _ in range(N*10+1)] for _ in range(N*10+1)] for _ in range(N+1)]
dp [0][0][0] = 0
for i in range(1,N+1):
   for j in range(N*10+1) :
       for k in range(N*10+1):
           x = j - a[i-1]
           y = k - b[i-1]
           if x>=0 and y>=0:
               dp[i][j][k] = min(dp[i-1][j][k],dp[i-1][x][y]+c[i-1])
           else:
               dp[i][j][k] = dp[i-1][j][k]
#Answer
cost = INF
for x,y in candidates:
    cost = min(cost,dp[N][x][y])
if cost == INF:
    print(-1)
else:
    print(cost)
