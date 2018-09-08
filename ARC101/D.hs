import Control.Applicative
main = do 
    getLine
    a <- map read . words <$> getLine
    print $ solve a

maxim = 10^9 + 1
solve list = bSearch 0 maxim (judge list) 

judge ys x = invNum <= div (div (l*(l+1)) 2) 2
    where (invNum,_) = inversionNumber cs
          cs = convert x ys
          l = length ys
convert x = scanl (\acc y-> if y>=x then acc+1 else acc-1) 0

bSearch ok ng condition = if ng == ok + 1 
                          then ok
                          else if condition mid 
                            then bSearch mid ng condition
                            else bSearch ok mid condition
                        where mid = div (ok+ng) 2

merge_ [] right _ = (0,right)
merge_ left [] _ = (0,left)
merge_ left@(x:xs) right@(y:ys) leftLength = if x <= y  
                                  then (ansx,x:xList)
                                  else (leftLength + ansy, y:yList)
    where (ansy, yList) = merge_ left ys leftLength
          (ansx,xList) = merge_ xs right (leftLength-1)

inversionNumber [] = (0,[])
inversionNumber [x] = (0,[x])
inversionNumber xs = (a+b+c,merged)
    where left = take half xs
          right = drop half xs
          half = length xs `div` 2
          (a,ileft) = inversionNumber left
          (b,iright) = inversionNumber right
          (c,merged) = merge_ ileft iright half