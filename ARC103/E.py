s = input()
n = len(s)
if s[0] == "0" or s[n-1] == "1":
    print(-1)
    exit()
if n%2 != 0:
    half = n//2
else:
    half = n//2 - 1
for i in range(1,half+1):
    if s[i-1] != s[n-i-1]:
        print(-1)
        exit()
