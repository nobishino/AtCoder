import numpy as np
from numpy.linalg import matrix_power
H,W,K=map(int,input().split())
def c(i,j):
    f=[1,1,2,3,5,8,13,21]
    a=0
    if i==j+1: a=f[j]*f[W-i-1]
    if j in (i,i+1): a=f[i]*f[W-j-1]
    return(a)
def mp(m,n,p):
    a = m%p
    if n==0:
        return(np.identity(m.diagonal().size,dtype='int32'))
    if n==1:
        return(a)
    else:
        q,r=divmod(n,2)
        x=np.matmul(a,a)%p
        if r==1:
            return(np.matmul(a,mp(x,q,p))%p)
        else:
            return(mp(x,q,p)%p)

m=mp(np.array([[c(i,j) for i in range(W)] for j in range(W)]),H,1000000007)
x=np.array([[c(i,j) for i in range(W)] for j in range(W)])
print(m[0,K-1])

          