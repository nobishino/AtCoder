N = int(input())

board = [["." for _ in range(N)] for _ in range(N)]
c = [0]
def spr(x,y):
    if x == -1:
        x = x+1
    if x == N:
        x = N-1
    if y == -1:
        y = y+1
    if y == N:
        y = N-1
    board[x][y] = "X"
    c[0] += 1


r = set(range(-1,N+1))
def inrange(x,y):
    return(x in r and y in r)

sx = 0
sy = 0
x = 0
y = 0
while 2*sx + sy <= 3*N:
    x = sx
    y = sy
    if inrange(x,y):
        while inrange(x,y):
            x += 1
            y -= 2
        x -= 1
        y += 2
    else:
        while not inrange(x,y):
            x -= 1
            y += 2
    while inrange(x,y):
        spr(x,y)
        x -= 1
        y += 2
    sx += 2
    sy += 1




for raw in board:
    print("".join(raw))
print(c[0])