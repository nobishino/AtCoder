#よくわからないので愚直を書くんです
N=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
ans = 0
for x in a:
    for y in b:
        ans = (x+y) ^ ans
print(ans)