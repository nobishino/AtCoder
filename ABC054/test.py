
N=100
ans = 0
table = [1 for _ in range(N+1)]
for i in range(1,N+1):
    table[i] = table[i-1]/i
def ifact(x):
    return(table[x])

for i in range(1,N):
    if i%2 == 0:
        ans -= ifact(i)
    else:
        ans += ifact(i)
print(ans)
