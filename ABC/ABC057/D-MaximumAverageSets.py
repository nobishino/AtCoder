import math
N,A,B = map(int,input().split())
v = list(map(int,input().split()))
d = {}
for value in v:
    if value not in d:
        d[value] = 1
    else:
        d[value] += 1
sortedDict = list(reversed(sorted(d.items(), key=lambda x: x[0])))
i = 0
s = 0
number = 0
while True:
    value,count = sortedDict[i]
    if A > count:
        A -= count
        B -= count
        i += 1
        s += count*value
        number += count
    else:
        s += A*value
        number += A
        break
        # A<=countが保証される
ans = 0
def combination(n,k):
    return (math.factorial(n)//math.factorial(k)//math.factorial(n-k))
if i == 0:
    upper = min(count,B)
    for j in range(A,upper+1):
        ans += combination(count,j)
else:
    ans = combination(count,A)
average = s/number
print(average)
print(ans)


