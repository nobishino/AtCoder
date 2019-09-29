N = int(input())
A = list(map(int,input().split()))
S = [0 for _ in range(N+1)]
for i in range(1,N+1):
    S[i] = S[i-1]+A[i-1] #strictly increasing
def binSearch(L,R):
    """
    L,R should be 1..N
    and L < R
    search for min(n) s.t. S[n]-S[L-1] >= half
    """
    total = S[R]-S[L-1]
    half = total/2 #it's float
    ok = R
    ng = L-1
    while ok >= ng+2:
        mid = (ok+ng)//2
        if S[mid]-S[L-1] >= half:
            ok = mid
        else:
            ng = mid
    deltaNG = abs(S[ng]-S[L-1]-half)
    deltaOK = abs(S[ok]-S[L-1]-half)
    if deltaNG < deltaOK:
        x = S[ng]-S[L-1]
        y = S[R] - S[ng]
    else:
        x = S[ok]-S[L-1]
        y = S[R] - S[ok]
    return(max(x,y),min(x,y))
def calcForMid(M):
    a,b = binSearch(1,M)
    c,d = binSearch(M+1,N)
    l = sorted([a,b,c,d])
    return(l[3]-l[0])
ans = S[N]
for m in range(2,N-1):
    ans = min(ans,calcForMid(m))
print(ans)


