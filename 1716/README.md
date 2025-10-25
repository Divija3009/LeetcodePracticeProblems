# LeetCode 1716 — Calculate Money in Leetcode Bank

Hercy deposits money every day:
- Day 1 (Monday): $1
- Tue..Sun: each day is $1 more than the previous day.
- Every next Monday starts $1 higher than the previous Monday.

Given `n`, compute the total saved after day `n`.

## Approaches

### 1) Closed-form arithmetic (O(1))
We split the days into full weeks and remaining days.

Let:
- `weeks = n // 7`  (number of complete weeks)
- `rem   = n % 7`   (remaining days, `0..6`)

**Full weeks**

Week sums form: `28, 35, 42, ...` i.e. `28 + 7*t` for `t = 0..weeks-1`.

Sum: 
28weeks + 7 * (0 + 1 + ... + (weeks-1))
= 28weeks + 7weeks(weeks-1)/2

**Remaining days**

They start from `(weeks + 1)` and increase by `1`

**Complexity:** Time `O(1)`, Space `O(1)`.


### 2) Iterative simulation (O(n))
Simulate the deposit day-by-day, resetting at each Monday and increasing the Monday base.

Pseudo:
- Keep `start` = deposit on the current week’s Monday.
- Keep `counter` = offset within the week (`0..6`).
- Sum `start + counter` for each day, bump `start` each new Monday.

See: `SolutionIterative.java`

**Complexity:** Time `O(n)`, Space `O(1)`.

---

## Examples
- `n = 4` → `1 + 2 + 3 + 4 = 10`
- `n = 10` → `28 (week1) + (2+3+4) = 37`
- `n = 20` → `28 + 35 = 63` for two weeks, plus next week’s first 6 days `3+4+5+6+7+8 = 33` → `96`