N = int(input())
a = []
for i in range(N):
    a.append([int(input()),i])
a.sort(key = lambda x: x[0])
zaatsu = 0
for i in range(N):
    if i == 0 or a[i][0] == a[i-1][0]:
        a[i].append(zaatsu)
    else:
        zaatsu += 1
        a[i].append(zaatsu)
a.sort(key = lambda x: x[1])
for v in a:
    print(v[2])