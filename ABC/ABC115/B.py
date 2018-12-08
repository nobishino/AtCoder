N = int(input())
p = []
maxp = 0
summ = 0
for i in range(N):
    p.append(int(input()))
    maxp = max(p[i],maxp)
    summ += p[i]
summ -= maxp//2
print(summ)
    