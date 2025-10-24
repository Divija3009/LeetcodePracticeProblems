# Approach A — Backtracking (Construct the next number)

Idea: Build only valid candidates by choosing digits from 1..9 such that digit d (if used) is used exactly d times.
We try with length len = digits(n); if nothing > n exists for that length, try len+1.

## How the recursion works

digitCount[d] starts as d (the remaining times d may be used).
We place digits to form a number of fixed length count.
Base case (count==0): valid if for each d, digitCount[d] is either 0 (used exactly d times) or d (never used). If valid and curr > n, return curr.
We stop early as soon as we find a valid answer.

# Approach B — Brute-force Scan

Idea: From n+1 up to 1,224,444, check each number with a frequency array and return the first balanced one.
