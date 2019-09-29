main = do
    [a,b] <- map read . words <$> getLine
    putStrLn $ solve a b
solve a b = if mod (a*b) 2 == 0
            then "No"
            else "Yes"