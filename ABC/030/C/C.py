N,M = map(int,input().split())
X,Y = map(int,input().split())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
ai = bi = loc = answer = 0

def trialSuccessful():
    global ai,bi,loc
    while ai < N and a[ai] < loc:
        ai += 1
    if ai == N: return False 
    loc = a[ai] + X
    while bi < M and b[bi] < loc:
        bi += 1
    if bi == M: return False
    loc = b[bi] + Y 
    return True

while trialSuccessful():
    answer += 1

print(answer)