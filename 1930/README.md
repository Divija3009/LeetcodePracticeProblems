#  1930. Unique Length-3 Palindromic Subsequences

## Approach
1. Track First and Last Occurrence
Use two arrays first[26] and last[26].
2. For each character 'a' to 'z':
If it appears at least twice:
- Look at the substring between first and last
- Add all characters into a Set<Character>
- The set size = number of unique palindromes with that outer character
3. Sum for all 26 characters.

This efficiently counts unique palindromes without duplicates.

## Time Complexity

Computing first/last occurrences: O(n)

For each of 26 letters, scanning inner range: O(n) worst-case
Overall: O(26 × n) ≈ O(n)

## Space Complexity

first[26], last[26]: O(1)