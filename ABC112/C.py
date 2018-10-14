N = int(input())
x = []
y = []
h = []
for _ in range(N):
    xx,yy,hh = map(int,input().split())
    x.append(xx)
    y.append(yy)
    h.append(hh)
cm = 100
def dist(cx,cy,x,y):
    return(abs(cx-x)+abs(cy-y))
for cx in range(cm+1):
    for cy in range(cm+1):
        H = -1
        Hm = 10000000000
        contra = False
        for i in range(N):
            Hi = h[i] + dist(cx,cy,x[i],y[i])
            if h[i] == 0:
                Hm = min(Hi,Hm)
            else:
                if H == -1:
                    H = Hi
                else:
                    if H!=Hi:
                        contra = True
                        break
            if H > Hm:
                contra = True
                break
        if contra == False:
            print(cx,cy,H)                
            exit()    
                    

