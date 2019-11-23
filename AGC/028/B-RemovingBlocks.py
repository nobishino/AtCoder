N = int(input())
a = list(map(int,input().split()))
MOD = 10**9 + 7
harmonic = [0 for _ in range(N+1)]
factorial = [1]
for i in range(1,N+1):
    im = pow(i,MOD-2,MOD)
    harmonic[i] = (harmonic[i-1] + im)%MOD
    factorial.append((factorial[i-1] * i)%MOD)
expectation = 0
for i in range(1,N+1):
    expectation += a[i-1]*(harmonic[i]+harmonic[N-i+1]-1)%MOD
    expectation %= MOD
answer = expectation*factorial[N]%MOD
print(answer)