import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
sys.setrecursionlimit(10**7)
inf = 10**20

def eratosthenes(upperBound):
    """エラトステネスの篩アルゴリズムによって、upperBound以下の素数すべてからなるリストを計算する。

    Args:
        upperBound(int): 計算したい素数リストに含まれる素数の上限値。
    Returns:
        list[int]: 計算された素数リスト。
    
    Examples:
    >>> eratosthenes(10)
    [2, 3, 5, 7]
    >>> eratosthenes(11)
    [2, 3, 5, 7, 11]
    """
    primeNumbers = []
    isPrime = [True for _ in range(upperBound + 1)]
    isPrime[0] = isPrime[1] = False
    divider = 0
    while divider <= math.sqrt(upperBound):
        if isPrime[divider]:
            # primeNumbers.append(divider)
            multiple = 2* divider
            while multiple <= upperBound:
                isPrime[multiple] = False
                multiple += divider
        divider += 1
    return [i for i in range(upperBound + 1) if isPrime[i]]

primeNumberList = eratosthenes(100)

def factorize(number):
    """与えられた整数を素因数分解する。素因数とその指数を辞書として返却する。

    Args:
        number(int) 
    Returns:
        dict[int,int] 素因数->指数の辞書。
    >>> factorize(6)
    {2: 1, 3: 1}
    >>> factorize(20)
    {2: 2, 5: 1}
    """
    exponents = {}
    for primeNumber in primeNumberList:
        while number%primeNumber == 0:
            number /= primeNumber
            if primeNumber in exponents:
                exponents[primeNumber] += 1
            else:
                exponents[primeNumber] = 1
    if number != 1:
        exponents[number] = 1
    return exponents
if __name__ == "__main__":
    import doctest
    doctest.testmod()