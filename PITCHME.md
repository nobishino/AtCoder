# AtCoder Commentary

presented by nobishino

---
@snap[north-east span-100 text-pink text-06]
ABC 142-B
@snapend

```python zoom-18
N,K = map(int,input().split())
h = list(map(int,input().split()))
answer = 0
for value in h:
    if value >= K:
        answer += 1
print(answer)
```
@snap[south span-100 text-gray text-08]
@[1-2](You can step-and-ZOOM into fenced-code blocks, source files, and Github GIST.)
@[3 zoom-13](Using GitPitch live code presenting with optional annotations.)
@[4-7, zoom-12](This means no more switching between your slide deck and IDE on stage.)
@snapend


