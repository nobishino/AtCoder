u = 4*10^4 :: Int
list = [2..u]
f :: [Int] -> [Int]
f [] = []
f (x:xs) = x:f (filter (\y->mod y x /= 0) xs)
main = print $ f list