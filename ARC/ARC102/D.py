L = int(input())
def divideBin(n):
    d = 1
    ans=[]
    while n > 0:
        r,q=divmod(n,2)
        ans.append(q*d)
        d *= 2
        n = r
    return(ans)
divided = divideBin(L)
N = len(divided)
M = 2*(N-1) + len([x for x in divided if x!=0]) - 1
print(N,M)
for i in range(1,N):
    print(i,i+1,0)
    print(i,i+1,pow(2,i-1))
node = N-1
value = divided[N-1]
while node > 0:
    if divided[node-1] != 0:
        print(node,N,value)
        value += divided[node-1]
    node -= 1