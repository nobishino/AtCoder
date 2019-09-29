

a=list(map(int,input().split()))
a.sort()
[A,B,C] = a

ans = int(str(C)+str(B)) + A
print(ans)