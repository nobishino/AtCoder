solve (n:k:[]) = (6.0 * (n-k) * (k - 1) + 3*n - 2) / n ^ 3
main = getLine >>= print . solve . map read . words
