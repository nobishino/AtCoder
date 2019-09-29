sx,sy,tx,ty = map(int,input().split())
answer = []
dx = tx-sx
dy = ty-sy
answer.append('R'*dx)
answer.append('U'*dy)
answer.append('L'*dx)
answer.append('D'*dy)
answer.append('D')
answer.append('R'*(dx+1))
answer.append('U'*(dy+1))
answer.append('L')
answer.append('U')
answer.append('L'*(dx+1))
answer.append('D'*(dy+1))
answer.append('R')
print("".join(answer))