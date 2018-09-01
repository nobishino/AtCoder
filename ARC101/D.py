N=int(input())
a=list(map(int,input().split()))

def solveFor(x):
    # x <= bなる要素がceil(M/2)以上ある　を条件A
    # 条件A = メディアンはx以上, Aを満たす最大のxがメディアン
    # xが条件Aを満たすか調べる
    # 部分列についてxがAを満たす = 部分列についてのメディアンがx以上
    # 部分列についてxがAを満たさない = 部分列についてのメディアンがx未満
    # 条件Aを満たす部分列の数を知りたい = solveFor(x)の返り値
    # 