N = int(input())
a = list(map(int,input().split()))
#a=[5,4,6,7,2,8,4,6,2,6,1,30]
#print(a)
#left,rightはそれぞれソート済みの配列
#マージして転倒数を返す
def merge(left,right):
    L = len(left)
    R = len(right)
    indexL = 0
    indexR = 0
    mergedList = []
    answer = 0
    while indexL < L and indexR < R:
        lElem = left[indexL]
        rElem = right[indexR]
        if  lElem <= rElem:
            mergedList.append(lElem)
            indexL += 1
            #print(indexL,indexR,lElem)
        else:
            mergedList.append(rElem)
            answer += L - indexL
            indexR += 1
            #print(indexL,indexR,rElem)
    while indexL < L:
        mergedList.append(left[indexL])
        indexL += 1
    while indexR < R:
        mergedList.append(right[indexR])
        indexR += 1
    return(answer,mergedList)

def inversionNum(acc,xs):
    L = len(xs)
    if L <= 1:
        return((acc,xs))
    half = L//2
    left = xs[0:half]
    right = xs[half:]
    ansL,sortedL = inversionNum(0,left)
    ansR,sortedR = inversionNum(0,right)
    ansM, mergedList = merge(sortedL,sortedR)
    return((acc+ansL+ansR+ansM,mergedList))

def judge(x):
    """
    求める中央値がx以上であるときTrue, x未満であるときFalseを返す
    """
    accum=[0]
    index = 0
    L = len(a)
    while index < L:
        if a[index] >= x:
            accum.append(accum[index]+1)
        else:
            accum.append(accum[index]-1)
        index += 1
    invNum,sList = inversionNum(0,accum)

    return(invNum <= L*(L+1)//4)

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
