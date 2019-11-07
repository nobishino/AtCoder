MOD = 2019
L,R = list(map(int,input().split()))
R = min(R, L + MOD)
nums = range(L,R+1)
answer = MOD
for i in range(L,R+1):
    for j in range(max(i+1,L), R+1):
        c = (i*j)%MOD
        # if c < answer:
            # print(c,i,j)
        answer = min(c,answer)
print(answer)