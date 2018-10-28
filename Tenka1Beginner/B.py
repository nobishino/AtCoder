a,b,K = map(int,input().split())
def exchange(A,B):
    if A%2 == 1:
        A -= 1
    C = A//2
    B += C
    A -= C
    return((A,B))
for i in range(K):
    if i%2 == 0:
        a,b=exchange(a,b)
    else:
        b,a=exchange(b,a)
print(a,b)