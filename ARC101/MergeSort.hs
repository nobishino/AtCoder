merge [] right = right
merge left [] = left
merge left@(x:xs) right@(y:ys) | x < y = x:(merge xs right)
                               | otherwise = y:(merge left ys)
mergeSort [] = []
mergeSort [x] = [x]
mergeSort xs = merge (mergeSort left) (mergeSort right)
    where left = take half xs
          right = drop half xs
          half = length xs `div` 2


merge_ [] right = (0,right)
merge_ left [] = (0,left)
merge_ left@(x:xs) right@(y:ys) = if x < y  
                                  then (ansx,x:xList)
                                  else (length left + ansRight, y:ansList)
    where (ansRight, ansList) = merge_ left ys
          (ansx,xList) = merge_ xs right

inversionNumber [] = (0,[])
inversionNumber [x] = (0,[x])
inversionNumber xs = (a+b+c,merged)
    where left = take half xs
          right = drop half xs
          half = length xs `div` 2
          (a,ileft) = inversionNumber left
          (b,iright) = inversionNumber right
          (c,merged) = merge_ ileft iright

