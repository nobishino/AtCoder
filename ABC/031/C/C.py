import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20
N = int(input())
a = list(map(int,input().split()))


def calcScoreForInterval(left,right):
    if right == left:
        return (-inf, -inf)
    if right < left:
        tmp = right
        right = left
        left = tmp
    takahashi = 0
    aoki = 0
    for i in range(left, right + 1):
        if (i-left) % 2 == 0:
            takahashi += a[i]
        else:
            aoki += a[i]
    # print(left,right,takahashi,aoki)
    return (takahashi,aoki)

def takahashi(t):
    bestAoki = -inf
    bestTakahashi = -inf
    for i in range(N):
        ta,ao = calcScoreForInterval(t,i)
        if ao > bestAoki:
            bestAoki = ao
            bestTakahashi = ta
    # print("takahashi",t,bestTakahashi)
    return bestTakahashi

def solve():
    bestScore = -inf
    for i in range(N):
        bestScore = max(bestScore, takahashi(i))
    return bestScore

# print(calcScoreForInterval(1,0))

print(solve())

