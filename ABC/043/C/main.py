import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20

N = input()
a = list(map(int,input().split()))
answer = inf
for goal in range(-100,101):
    squaredSum = sum(map(lambda x: (x-goal)**2, a))
    answer = min(answer, squaredSum)
print(answer)