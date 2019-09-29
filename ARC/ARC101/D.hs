module Main where
import Control.Applicative

main = do 
    n <- read <$> getLine
    a <- map read . words <$> getLine
    print $ solve a n

maxim = 10^9 + 1 :: Int
solve :: [Int] -> Int -> Int
solve list n = bSearch 0 maxim (judge n list) 

judge :: Int -> [Int] -> Int -> Bool
judge n list x = invNum <= div (n*(n+1)) 4
    where invNum = sum . map snd . table $! convert x list

convert :: Int -> [Int] -> [Int]
convert x = scanl (\acc y-> if y>=x then acc-1 else acc+1) 0

bSearch :: Int -> Int -> (Int -> Bool) -> Int
bSearch ok ng condition  | ng == ok + 1 = ok
                         | condition mid = bSearch mid ng condition
                         | otherwise = bSearch ok mid condition
                        where mid = div (ok + ng) 2
join :: Int -> [(Int,Int)] -> [(Int,Int)] -> [(Int,Int)]
join _ [] tys = tys
join _ txs [] = txs
join n txs@((x,c):txs_) tys@((y,d):tys_)
    | x < y = join n txs_ tys `seq` (x,c+n):join n txs_ tys
    | x >= y = join (n-1) txs tys_ `seq` (y,d): join (n-1) txs tys_
table :: [Int] -> [(Int,Int)]
table [] = []
table [x] = [(x,0)]
table xs = (join (m-n) $! table left) $! table right
    where m = length xs
          n = div m 2
          (left,right) = splitAt n xs