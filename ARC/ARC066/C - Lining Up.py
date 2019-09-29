N = int(input())
a = list(map(int,input().split()))
center = 0
M = N//2
parity = N%2
capacity = [0 for _ in range(M)]
failed = False
for i in range(N):
    if a[i]%2 == parity:
        failed = True
        break
    if a[i] < 0 or a[i] > N-1:
        failed = True
        break
    if a[i] == 0:
        center += 1
    else:
        j = (N-a[i])//2
        capacity[j] += 1
if parity == 1 and center != 1:
    failed = True
answer = 1
MOD = 10**9+7
for c in capacity:
    if c!=2:
        failed = True
        break
    else:
        answer *= 2
        answer %= MOD

if failed:
    print(0)
else:
    print(answer)
