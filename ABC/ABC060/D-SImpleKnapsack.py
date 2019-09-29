N,W = map(int,input().split())
v = [[] for _ in range(4)]
w0,vv = map(int,input().split())
v[0].append(vv)
for _ in range(N-1):
    ww,vv = map(int,input().split())
    v[ww-w0].append(vv)
for i in range(4):
    v[i].sort(reverse=True)
cum =[[0] for _ in range(4)]
for i in range(4):
    for j in range(len(v[i])):
        cum[i].append(cum[i][j]+v[i][j])
ans = 0
for i in range(len(v[0])+1):
    for j in range(len(v[1])+1):
        for k in range(len(v[2])+1):
            for l in range(len(v[3])+1):
                if (i+j+k+l)*w0 + j + 2*k + 3*l > W:
                    continue
                #ここから下は制約を満たすことが保証される
                candidate = cum[0][i] + cum[1][j] + cum[2][k] + cum[3][l]
                ans = max(ans,candidate)
print(ans)




