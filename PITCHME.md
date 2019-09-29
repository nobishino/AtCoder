# AtCoder Solutions and Commentary by shino

---

## Slide 1

```py
N,K = map(int,input().split())
h = list(map(int,input().split()))
ans = 0
for value in h:
    if value >= K:
        ans += 1
print(ans)
```
