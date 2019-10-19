import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20

N = int(input())
a = list(map(int,input().split()))
ans = 0
for x,y in itertools.combinations(a,2):
    ans += x*y
print(ans)