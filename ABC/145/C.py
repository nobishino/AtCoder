import itertools,math
N = int(input())
x = [] 
y = []
for _ in range(N):
    a,b = map(int,input().split())
    x.append(a)
    y.append(b)
summation = 0

def dist(i,j):
    return math.sqrt((x[i] - x[j])**2 + (y[i]-y[j])**2)
permutations = list(itertools.permutations(range(N)))
for perm in permutations:
    subSum = 0
    for i in range(N-1):
        subSum += dist(perm[i], perm[i+1])
    summation += subSum

answer = summation / len(permutations)
print(answer)