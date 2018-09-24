N,M,X,Y=map(int,input().split())
xs = list(map(int,input().split()))
ys = list(map(int,input().split()))
mx = max(xs)
mx = max(mx,X)
my = min(ys)
my = min(my,Y)
if mx >= my: 
    print("War")
else:
    print("No War")