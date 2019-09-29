N = int(input())
a = list(map(int,input().split()))

class BIT():
    def __init__(self,length):
        self.length = length
        self.values = [0 for _ in range(length+1)]
    
    def add(self,location,value):
        x = location
        while x < self.length + 1:
            self.values[x] += value
            x += x & -x
    
    def sum(self,right):
        x = right
        answer = 0
        while x > 0:
            answer += self.values[x]
            x -= x & -x
        return(answer)

def judge(x):
    bit = BIT(2*N + 1)
    bit.add(N+1,1)
    cumsum = 0
    validNum = 0
    interval = N*(N+1)//2
    lowbound = interval - interval//2
    for i in range(N):
        if a[i] >= x:
            cumsum += 1
        else:
            cumsum -= 1
        validNum += bit.sum(cumsum+N+1)
        bit.add(cumsum+N+1,1)
    return(validNum >= lowbound)    
    
def solve(ok,ng):
    """
    解が[ok,ng)に入ることを前提に2分探索をし、judge(x)==Trueとなる最大のxを求める。
    judge(x)の性質は2分探索が可能なものであることを仮定する。
    """
    if ok + 1 == ng:
        return(ok)
    mid = (ok+ng)//2
    if judge(mid):
        return(solve(mid,ng))
    else:
        return(solve(ok,mid))

print(solve(0,10**9+1))