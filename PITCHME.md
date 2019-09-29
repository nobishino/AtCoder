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
@[3](Using GitPitch live code presenting with optional annotations.)
@[4-7](This means no more switching between your slide deck and IDE on stage.)
@snapend

---?code=ABC/141/ER.py&lang=py

@snap[north-east span-100 text-06 text-gray]
Live Code Presenting with Annotations                         
@snapend

@snap[south span-100]
@[1](Socket.IO enables real-time, bidirectional, event-based communication.)
@[2,3](Tweet Stream is node module that connects to the public twitter stream.)
@[5-10](To process interesting Tweets, simply register a custom handler.)
@snapend


