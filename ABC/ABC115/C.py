N,K = map(int,input().split())
h = []
for _ in range(N):
    h.append(int(input()))
h.sort()
minimum = h[N-1]-h[0]
for i in range(N-K+1):
    minimum = min(minimum,h[i+K-1]-h[i])
print(minimum)
