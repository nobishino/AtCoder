# ABC142-C

---

```py
N = int(input())
A = list(map(int,input().split()))
answers = [-1 for _ in range(N)]
for i in range(N):
    answers[A[i]-1] = i+1
print(" ".join(map(str,answers)))
```

@snap
@[1-2]
@[3]
@[4-5]
@[6]
@snapend