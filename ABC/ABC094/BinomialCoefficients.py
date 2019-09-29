n = int(input())
a = list(map(int,input().split()))
maxim = 0
for x in a:
    maxim = max(x,maxim)
delta = a
halfFloor = maxim//2
halfCeil = halfFloor
if maxim%2 == 1:
    halfCeil += 1
delta = maxim
for x in a:
    if x == maxim:
        continue
    if x <= halfFloor:
        if halfFloor - x < delta:
            candidate = x        
            delta = halfFloor - x
    else:
        if x - halfCeil < delta:
            candidate = x
            delta = x - halfCeil
print(maxim,candidate)
