N,M=map(int,input().split())
import math
s = math.sqrt(M)
sq = math.floor(s)
l = []
for i in range(1,sq+1):
    if M%i == 0:
        l.append(i)
        l.append(M//i)
ans = 1
for r in l:
    n = M//r
    if n >= N:
        ans = max(ans,r)
print(ans)