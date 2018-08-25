import Control.Applicative
main = do
    getLine
    a <- map read . words <$> getLine
    print $ solve a
modulo = 10^9 + 7 :: Integer
solve :: [Integer] -> Integer
solve = foldl1 (\x y->mod (2+x*y+2*x+2*y) modulo)
