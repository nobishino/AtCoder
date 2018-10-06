n = int(input())
v = list(map(int,input().split()))
ecost = [n//2 for _ in range(100001)]
ocost = [n//2 for _ in range(100001)]
for i in range(n):
    if i%2 == 0:
        ecost[v[i]] -= 1
    else:
        ocost[v[i]] -= 1
e1 = ecost[1]
ve1 = 1
e2 = ecost[2]
ve2 = 2
o1 = ocost[1]
vo1 = 1
o2 = ocost[2]
vo2 = 2
for i in range(3,100001):
    ecand = ecost[i]
    ocand = ocost[i]
    if ecand <= e1:
        e2 = e1
        e1 = ecand
        ve2 = ve1
        ve1 = i
    elif ecand <= e2:
        e2 = ecand
        ve2 = i
    if ocand <= o1:
        o2 = o1
        o1 = ocand
        vo2 = vo1
        vo1 = i
    elif ocand <= o2:
        o2 = ocand
        vo2 = i
if vo1 != ve1:
    ans = o1 + e1
else:
    ans = e1 + min(o2,e2)
print(ans)
        

