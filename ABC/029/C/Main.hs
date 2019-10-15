import Control.Monad
import Data.List
main = readLn >>= (mapM putStrLn) (sort . solve)
solve :: Int -> [String]
solve 0 = [""]
solve n = solve (n-1) >>= append
    where append string = map (:string) "abc"