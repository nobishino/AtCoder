N=int(input())
T,A=map(int,input().split())
h = list(map(int,input().split()))
dist = 10**6
ans = -1
c = 0.006
for i in range(N):
    if abs(T-c*h[i]-A) < dist:
        dist = abs(T-c*h[i]-A)
        ans = i+1
print(ans)
