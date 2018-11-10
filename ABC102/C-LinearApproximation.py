N=int(input())
A=list(map(int,input().split()))
B=[0 for _ in range(N)]
for i in range(N):
    B[i] = A[i] - (i+1)
B.sort()
b=B[N//2]
ans=sum([abs(x-b) for x in B])
print(ans)