#座標も数値も全部0-indexedに直す
H,W,D=map(int,input().split())
coordinate = [None for _ in range(H*W)]
for i in range(H):
    raw = list(map(int,input().split()))
    for j in range(W):
        coordinate[raw[j]-1] = (i,j)
l = H*W//D + 2
cumm = [[0 for _ in range(l)] for _ in range(D)]
for i in range(H*W):
    q,r = divmod(i,D)
    if q==0:
        continue
    #q>0
    x1,y1 = coordinate[i]
    x0,y0 = coordinate[i-D]
    distance = abs(x1-x0) + abs(y1-y0)
    cumm[r][q] = cumm[r][q-1] + distance
Q = int(input())
for _ in range(Q):
    L,R = map(int,input().split())
    q0,r0 = divmod(L-1,D)
    q1,r1 = divmod(R-1,D)
    print(cumm[r1][q1]-cumm[r0][q0])
