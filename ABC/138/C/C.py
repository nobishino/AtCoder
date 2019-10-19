N = int(input())
a = list(map(int,input().split()))
import heapq
heapq.heapify(a)
for i in range(N-1):
  x = heapq.heappop(a)
  y = heapq.heappop(a)
  z = (x+y)/2
  heapq.heappush(a,z)
answer = heapq.heappop(a)
print(answer)