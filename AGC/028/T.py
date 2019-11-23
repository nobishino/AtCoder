import itertools
def rem(i,n,c,e):
    e[i] = False
    c[i] += 1
    j = i+1
    while j<n and e[j]:
        c[j] += 1
        j += 1
    j = i-1
    while j>=0 and e[j]:
        c[j] += 1
        j -= 1
N = 10

def simulate(n):
    cost = [0 for _ in range(n)]
    for seq in itertools.permutations(range(n)):
        exists = [True for _ in range(n)]
        for i in seq:
            rem(i,n,cost,exists)
    for i in range(n):
         print("coefficient_"+str(i), cost[i])

for i in range(2,9):
    print("N = " + str(i))
    simulate(i)


