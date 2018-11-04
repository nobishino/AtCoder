import math
N = 10**5+1
numbers = [i for i in range(2,N+1)]
primes = []
x = numbers[0]
while x <= math.ceil(math.sqrt(N))+1:
    x = numbers[0]
    primes.append(x)
    numbers = [num for num in numbers if num%x != 0]
pset = set(primes) | set(numbers)
oddPrimes = [number for number in pset if (number+1)//2 in pset]
oddPrimes.sort()
#print(oddPrimes)
cumsum = [0 for _ in range(N+1)]
j=0
length = len(oddPrimes)
nextOP = oddPrimes[j]
for i in range(1,N+1):
    if i != nextOP:
        cumsum[i] = cumsum[i-1]
    else:
        cumsum[i] = cumsum[i-1] + 1
        if j+1 < length:
            j += 1
            nextOP = oddPrimes[j]
        else:
            nextOP = -1
Q = int(input())
for _ in range(Q):
    l,r = map(int,input().split())
    print(cumsum[r]-cumsum[l-1])





    
