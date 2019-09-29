import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20

N,K = map(int,input().split())
h = list(map(int,input().split()))
ans = 0
for value in h:
    if value >= K:
        ans += 1
print(ans)