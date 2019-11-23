import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time

MOD = 998244353
N = int(input())
D = list(map(int,input().split()))
maxD = 0
count = [0 for _ in range(N)]
for d in D:
    maxD = max(maxD,d)
    count[d] += 1
answer = 1
for i in range(maxD):
    x = count[i]
    y = count[i+1]
    answer *= pow(x,y,MOD)
    answer %= MOD
if count[0] != 1 or D[0] != 0:
    print(0)
else:
    print(answer)