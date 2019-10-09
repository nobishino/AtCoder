import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20
N = int(input())
a = map(int,input().split())
index = range(1,N+1)
table = sorted(zip(a,index),key = lambda x: -x[0])
for value in table:
    print(value[1])