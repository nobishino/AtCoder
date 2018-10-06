N = int(input())
x = [0 for _ in range(N)]
y = [0 for _ in range(N)]
z = [0 for _ in range(N)]
for i in range(N):
    X,Y = map(int,input().split())
    x[i] = X
    y[i] = Y
    z[i] = X+Y
ans = 0
if z[0]%2 == 0:
    even = True
else:
    even = False
for i in range(1,N):
    if even:
        if z[i]%2 ==0:
            continue
        else:
            ans = -1
            break
    else:
        if z[i]%2 !=0:
            continue
        else:
            ans = -1
            break
if ans==-1:
    print(ans)
    exit()
if even:
    m = 40
else:
    m = 39

print(m)
print(" ".join("1" for _ in range(m)))
for i in range(N):
    X = x[i]
    Y = y[i]
    stringX = ""
    stringY = ""
    if X > 0:
        stringX = "R"*X
    if X < 0:
        stringX = "L"*abs(X)
    if Y > 0:
        stringY = "U"*Y
    if Y < 0:
        stringY = "D"*abs(Y)

    z = (m - abs(X) - abs(Y))//2 #m-x-y is even
    stringZ = "UD"*z
    print(stringX+stringY+stringZ)
