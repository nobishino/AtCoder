main :: IO ()
main = getLine >>= solve
-- getLine :: IO String
solve :: String -> IO ()
solve string = if (tappable string)
    then putStrLn "Yes"
    else putStrLn "No"

helper :: Int -> Char -> Int
helper  1 'L' = 0
helper (-1) 'R' = 0
helper 1 _ = -1
helper (-1) _ = 1
helper 0 _ = 0

tappable :: String -> Bool 
tappable = (/=0) . foldl helper 1