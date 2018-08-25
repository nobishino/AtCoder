S=55
a = [i for i in range(1,S+1)]
print(a)
b=[]
b.append(a)

N=15
for i in range(1,N):
    x = 0
    b.append([0 for _ in range(S)])
    for j in range(S):
        x += b[i-1][j]
        b[i][j] = x
    #print(b[i])
ans=[]
left=[]
right=[]
for k in range(N-1):
    flag = False
    for i in range(S):
        if flag:
            break
        for j in range(S):
            if flag:
                break
            if b[k][i] == b[k+1][j] and i*j !=0:
                print(k+1,i+1,j+1,b[k][i])
                ans.append(b[k][i])
                left.append(i+1)
                right.append(j+1)
                flag = True
print(left)
print(right)