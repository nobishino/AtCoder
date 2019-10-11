N,Q = map(int,input().split())
inversion = [False for _ in range(N)]
for _ in range(Q):
    l,r = map(int,input().split())
    inversion[l - 1] = not inversion[l - 1]
    if r - 1< N - 1: inversion[r] = not inversion[r]
    # print(inversion)
black = True
answer = []
for i in range(N):
    if inversion[i]:
        black = not black
    if black:
        answer.append('0')
    else:
        answer.append('1')
print("".join(answer))