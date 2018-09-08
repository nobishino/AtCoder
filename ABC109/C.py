N,X=map(int,input().split())
xs = list(map(int,input().split()))

def gcd( x, y ):
    while y != 0:
        x, y = y, x%y
    return(x)
    

xs[0] -= X
g = xs[0]
import math
for i in range(1,N):
    xs[i] -= X
    g = gcd(g,xs[i])
print(g)