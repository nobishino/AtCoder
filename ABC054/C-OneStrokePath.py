import itertools

N,M=map(int,input().split())
link = [set() for _ in range(N+1)]
for _ in range(M):
    a,b = map(int,input().split())
    link[a].add(b)
    link[b].add(a)
sqs = itertools.permutations(range(2,N+1))
ans = 0
for sq in sqs:
    v = 1
    success = 1
    for w in sq:
        if w in link[v]:
            v = w
        else:
            success = 0
            break
    ans += success
print(ans)



