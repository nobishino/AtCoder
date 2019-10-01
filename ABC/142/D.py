import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20


A,B = map(int,input().split())
gcd = fractions.gcd(A,B)
print(gcd)