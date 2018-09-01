#N=int(input())
#a=list(map(int,input().split()))
import random
N = 5
a=[]
for i in range(N):
    a.append(random.randint(-10,10))
print(a)
import statistics as st
medians = []
table =[[0 for _ in range(N)] for _ in range(N)]
for l in range(N):
    for r in range(l,N):
        b = [a[i] for i in range(l,r+1)]
        med = st.median_high(b)
        medians.append(med)
        #print(l,r,med)
        table[l][r] = med
#for raw in table:
#    print(raw)
answer = st.median_high(medians)
#print("answer = ",answer)
a.sort()
#print(a)
for i in range(N):
    if a[i] == answer:
        print(a,i-N//2)
        break





