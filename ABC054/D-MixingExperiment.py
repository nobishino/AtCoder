import copy
N,Ma,Mb = map(int,input().split())
qa=Ma
qb=Mb
candidates = []
while qa <= 400 and qb <= 400:
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
dp = [[[] for _ in range(401)] for _ in range(N+1)]
dp[0][0].append([])
for i in range(N):
    j = i+1
    for A in range(401):
        dp[j][A] = copy.deepcopy(dp[j-1][A])
        if A >= a[i]:
            for seq in dp[j-1][A-a[i]]:
                newseq = copy.deepcopy(seq)
                newseq.append(i)
                dp[j][A].append(newseq)

#後半
ans = 100000
for cand in candidates:
    A,B = cand
    for bseq in dp[N][A]:
        s = 0
        cost = 0
        for i in bseq:
            s += b[i]
            cost += c[i]
        if s == B:
            ans = min(ans,cost)
if ans != 100000:
    print(ans)
else:
    print(-1)
            

            