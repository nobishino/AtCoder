N = int(input())
a = list(map(int,input().split()))
cumsum = [0 for _ in range(N+1)]
for i in range(N):
    cumsum[i+1] = cumsum[i] + a[i]

def min2div(i,j):
    """
    区間[i,j]の分割による最小値を求める
    """
    ans = N*10**9
    l = 0
    r = 0
    for k in range(i,j):
        left = cumsum[k+1]-cumsum[i]
        right =cumsum[j+1]-cumsum[k+1]
        if abs(left-right)<ans:
            ans = abs(left-right)
            l = left
            r = right
    return(ans,l,r)

print(min2div(0,N-1))
