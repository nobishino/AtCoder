import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20
N = int(input())
a = list(map(int,input().split()))
i = 0
j = 0 
answer = 0
while True:
    if j < i:
        j = i
    while j+1 < N and a[j] < a[j+1]:
        j += 1
    answer += j - i + 1
    if i == N - 1:
        break
    i += 1
print(answer)