import Data.List
tripleLoop = [(i,j,k)| i <- [0..4], j <- [0..4], k <- [0..4], i < j, j < k]
calcSum values (i,j,k) = values!!i + values!!j + values!!k
main = do
    nums <- map read . words <$> getLine
    let sums = sort $ map (calcSum nums) tripleLoop
    print $ sums!!7