import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20

N = int(input())
S = input()
prev = "?"
ans = 0
for c in S:
    if c != prev:
        ans += 1
        prev = c
print(ans)
