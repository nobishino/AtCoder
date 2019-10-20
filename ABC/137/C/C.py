import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20

N = int(input())
dict = {}
for _ in range(N):
    str = input()
    st = ''.join(sorted(str))
    if st not in dict:
        dict[st] = 1
    else:
        dict[st] += 1
answer = 0
for key in dict:
    l = dict[key]
    answer += l*(l-1)//2
# print(dict)
print(answer)