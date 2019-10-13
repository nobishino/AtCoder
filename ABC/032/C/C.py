import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20

N,K = map(int,input().split())
s = []
for _ in range(N):
    s.append(int(input()))

product = 1
answer = 0
j = -1
for i in range(N):
    if j < i:
        product = 1
        j = i - 1
    while j + 1 < N and product * s[j + 1] <= K:
            product *= s[j + 1]
            j += 1
    # print(i,j,j - i + 1)
    answer = max(answer, j - i + 1)
    if s[i] == 0:
        answer = N
        break
    product //= s[i]
# print(product)
print(answer)

