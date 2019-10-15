ABC141 - B

---

https://atcoder.jp/contests/abc141/tasks/abc141_b

---

```hs
main :: IO ()
main = getLine >>= solve 
-- getLine :: IO String

solve :: String -> IO ()
solve string = if (tappable string)
    then putStrLn "Yes"
    else putStrLn "No"

tappable :: String -> Bool 
tappable = (/=0) . foldl helper 1
```
@[2](>>= でつなぐのがなんとなくthenっぽい)

---

```hs
main :: IO ()
main = do
    s <- getLine 
    solve s

solve :: String -> IO ()
solve string = if (tappable string)
    then putStrLn "Yes"
    else putStrLn "No"

tappable :: String -> Bool 
tappable = (/=0) . foldl helper 1
```
@[2-4](do構文つかうとなんとなくasync/awaitっぽい)

---
### helperの中身

```hs
helper :: Int -> Char -> Int
helper  1 'L' = 0
helper (-1) 'R' = 0
helper 1 _ = -1
helper (-1) _ = 1
helper 0 _ = 0
```
