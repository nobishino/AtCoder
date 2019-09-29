import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
N,M = map(int,input().split())
A = list(map(int,input().split()))
B = [-a for a in A]
heapq.heapify(B)
for _ in range(M):
    v = heapq.heappop(B)
    v = -(abs(v)//2)
    heapq.heappush(B, v)
print(-sum(B))