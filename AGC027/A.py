N,x = map(int,input().split())
a = list(map(int,input().split()))
a.sort()
left=0
right=0
s=a[0]
answer = 0
while True:
    if left >= N or right >= N:
        break
    if s <= x:
        if s == x:
            answer = max(answer,right-left+1)
        if s < x:
            if right-left < N-1:
                answer = max(answer,right-left+1)
        right += 1
        if right < N:
            s += a[right]
        continue
    if s > x:
        s -= a[left]
        left += 1
        continue
print(answer)