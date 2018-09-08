H,W = map(int,input().split())
a = []
for i in range(H):
    a.append(list(map(int,input().split())))
if H%2 == 1:
    endGrid=(H-1,W-1)
else:
    endGrid=(H-1,0)

answer = []
def move(i,j):
    if (i,j) == endGrid:
        return()
    if i%2 == 0:
        if j<W-1:
            #print(movingOdd)
            answer.append(" ".join(map(str,[i+1,j+1,i+1,j+2])))
        else:
            answer.append(" ".join(map(str,[i+1,j+1,i+2,j+1])))
            #print(movingOdd)
    else:
        if j>0:
            answer.append(" ".join(map(str,[i+1,j+1,i+1,j])))
            #print(movingOdd)
        else:
            answer.append(" ".join(map(str,[i+1,j+1,i+2,j+1])))
            #print(movingOdd)
            
evenraw = True
movingOdd = False
for i in range(H):
    if evenraw:
        j = 0
        while j < W:
            #print(i,j,movingOdd,"right")
            if movingOdd:
                if a[i][j]%2 == 0:
                    move(i,j)
                else:
                    movingOdd = False
            else:
                if a[i][j]%2 == 1:
                    move(i,j)
                    movingOdd = True
            j += 1
        evenraw = False
    else:
        j = W-1
        while j >= 0:
            #print(i,j,movingOdd,"left")
            if movingOdd:
                if a[i][j]%2 == 0:
                    move(i,j)
                else:
                    movingOdd = False
            else:
                if a[i][j]%2 == 1:
                    move(i,j)
                    movingOdd = True
            j -= 1
        evenraw = True


print(len(answer))
for ans in answer:
    print(ans)
