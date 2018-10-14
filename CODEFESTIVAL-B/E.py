N=30
eraw = ["." for _ in range(N)]
fraw = []
for i in range(N):
    if i%3 == 1:
        fraw.append("X")
    else:
        fraw.append(".")
fraw = "".join(fraw)
eraw = "".join(eraw)
print(fraw)