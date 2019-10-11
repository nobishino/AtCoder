import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20

N,K = map(int,input().split())
a = list(map(int,input().split()))
s = [0]
for i in range(N):
    s.append(s[i] + a[i])
answer = 0
for i in range(K,N+1):
    answer += s[i] - s[i - K]
print(answer)
