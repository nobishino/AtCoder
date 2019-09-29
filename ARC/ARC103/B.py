N=int(input())
r,q=divmod(N,100)
if r*11 >= q:
    print(r*111)
else:
    print((r+1)*111)