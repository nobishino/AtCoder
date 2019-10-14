ABC141 - B

---

https://atcoder.jp/contests/abc141/tasks/abc141_b

---

```hs
main :: IO ()
main = getLine >>= solve -- getLine :: IO String

solve :: String -> IO ()
solve string = if (tappable string)
    then putStrLn "Yes"
    else putStrLn "No"

tappable :: String -> Bool 
tappable = (/=0) . foldl helper 1
```