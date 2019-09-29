import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20

N = int(input())
A = list(map(int,input().split()))
answers = [-1 for _ in range(N)]
for i in range(N):
    answers[A[i]-1] = i+1
print(" ".join(map(str,answers)))