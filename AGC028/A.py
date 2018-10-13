import fractions as frc
N,M=map(int,input().split())
S = input()
T = input()
L = (N*M)//frc.gcd(N,M)
n = L//N
m = L//M
d = {}
for i in range(N):
    d[n*i] = S[i]
for i in range(M):
    if m*i in d:
        if d[m*i] != T[i]:
            print(-1)
            exit()
print(L)