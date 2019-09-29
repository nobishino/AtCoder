# AtCoder Commentary

presented by nobishino

---

ABC 142-B

```py
N,K = map(int,input().split())
h = list(map(int,input().split()))
answer = 0
for value in h:
    if value >= K:
        answer += 1
print(answer)
```
