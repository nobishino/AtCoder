from collections import deque
N = int(input())
a = []
for _ in range(N):
    a.append(int(input()))
a.sort()
dq = deque()
j = 0
k = N-1
for i in range(N):
    if i%4 == 0:
        dq.append(a[j])
        j += 1
    if i%4 == 3:
        dq.appendleft(a[j])
        j += 1
    if i%4 == 1:
        dq.appendleft(a[k])
        k -= 1
    if i%4 == 2:
        dq.append(a[k])
        k -= 1
ans = 0
v = dq.popleft()
for w in dq:
    ans += abs(v-w)
    v = w
print(ans)
    

