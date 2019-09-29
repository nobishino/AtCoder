import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20

N,K,Q = map(int,input().split())
win = [0 for _ in range(N)]
for i in range(Q):
    winner = int(input()) - 1
    win[winner] += 1
for i in range(N):
    if K - Q + win[i] > 0:
        print('Yes')
    else:
        print('No')