import itertools
def calc(N,K):
    seq = range(1,K+1)
    return(list(itertools.combinations_with_replacement(seq,N)))

def solve(N,K):
    candidates = calc(N,K)
    #print(len(candidates))
    ans = [len(candidates) for _ in range(2*K + 1)]
    for candidate in candidates:
        appeared = set()
        pairs = itertools.combinations(candidate,2)
        for pair in pairs:
            appeared.add(sum(pair))
        for value in appeared:
            ans[value] -= 1
        
    return(ans)

def main(N,K):
    answer = solve(N,K)
    ans = [answer[i] for i in range(2,2*K+1)]
    answer = map(str,ans)
    print(" ".join(answer))

K = 9
print("K = ",K)
for j in range(2,2*K+1):
    for N in range(1,10):
        #print(K,N)
        answer=solve(N,K)
        print(answer[j])
