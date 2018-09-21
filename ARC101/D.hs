module Main where
import Control.Applicative

main = do 
    getLine
    a <- map read . words <$> getLine
    print $ solve a

maxim = 10^9 + 1 :: Int
solve :: [Int] -> Int
solve list = bSearch 0 maxim (judge list) 

judge :: [Int] -> Int -> Bool
judge ys x = invNum <= div (div (l*(l+1)) 2) 2
    where (invNum,_) = inversionNumber cs
          cs = convert x ys
          l = toInteger $ length ys

convert :: Int -> [Int] -> [Int]
convert x = scanl (\acc y-> if y>=x then acc+1 else acc-1) 0

bSearch :: Int -> Int -> (Int -> Bool) -> Int
bSearch ok ng condition  | ng == ok + 1 = ok
                         | condition mid = bSearch mid ng condition
                         | otherwise = bSearch ok mid condition
                        where mid = div (ok + ng) 2

merge_ :: [Int] -> [Int] -> Integer -> (Integer,[Int])
merge_ [] right _ = (0,right)
merge_ left [] _ = (0,left)
merge_ left@(x:xs) right@(y:ys) leftLength = if x <= y  
                                  then seq (ansx,xList) (ansx,x:xList)
                                  else seq (ansy, yList) (leftLength + ansy, y:yList)
    where (ansx,xList) = merge_ xs right (leftLength-1)
          (ansy, yList) = merge_ left ys leftLength

inversionNumber :: [Int] -> (Integer,[Int])
inversionNumber [] = (0,[])
inversionNumber [x] = (0,[x])
inversionNumber xs = seq (c,merged) (a+b+c,merged)
    where left = take half xs
          right = drop half xs
          half = length xs `div` 2
          (a,ileft) = inversionNumber left
          (b,iright) = inversionNumber right
          (c,merged) = seq (a,b,ileft,iright) merge_ ileft iright (toInteger half):q