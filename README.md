# AtCoder 
- コンテスト中に書いたものは原則としてA.py, B.pyなどのファイル名で書く
- コンテスト中以外に書いたものは原則として問題タイトルをファイル名にする。MediansOfMedians.pyなど

# できるかもリスト
- グラフ
-- BFS,DFS
- にぶたん
- DP
- 累積和
- 合同式/MOD/Parity
- 最大公約数、ユークリッドの互除法
- 貪欲
- しゃくとり

## 300以上を解くときの心掛け
- 気づいたことはできるだけ明確に言語化して文字に書く
- 面白いことに気づいたらそれを言語化し、いったん思考をリセットする（それまでに考えていたことへのこだわりを消す）
## にぶたん
### できること
- ある条件を満たすxの最大値・最小値を高速に求めることができる。
- O(log A), Aは候補を探す幅
### いつできるか
- ある条件を、「xが満たすならばx' <= xなるx'もまた満たす」というのが成り立つとき。
- 対偶：x'が満たさないならばx'よりも大きいxもまた満たさない、というのが成り立つとき。
### いつできないか
- xが満たすとしてもxより小さいx'がそれを満たさない場合があるとき。
- 対偶：x'が満たさないがx'よりも大きいxは満たす、というのがあり得るとき。
### 例題
- [Medians of Medians](https://beta.atcoder.jp/contests/arc101/tasks/arc101_b)
### その他
- 中間値は適用条件を満たす: x>=yなるyが半数以上であるxの最小値、のように言い換える
## しゃくとり
### できること
- ある条件を満たす区間の数を高速に数えることができる。
- O(N), Nは区間の幅
### いつできるか
- [a,b]が満たすならばそれに含まれる[a',b']も満たす（単調性）
### いつできないか
- [a,b]が満たすのにそれに含まれる[a', b']は満たさないかもしれない
### 例題
- [Xor Sum 2](https://beta.atcoder.jp/contests/abc098/tasks/arc098_b)





# 消化できてないことがらのノート
- 転倒数
-- いつつかうか？
-- マージソートによる方法
