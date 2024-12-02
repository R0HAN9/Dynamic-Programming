# Dynamic-Programming


Dynamic Programming (DP) is a method used to solve complex problems by breaking them into smaller, simpler problems. It is particularly useful for problems with overlapping subproblems and optimal substructure.<br><br>


---

<h3>Key Concepts of DP</h3>

<strong>1. Overlapping Subproblems</strong><br>
Some problems require solving the same smaller problems repeatedly. Instead of recalculating them, DP stores these results in a table and reuses them.<br>
Example: In the Fibonacci sequence, calculating `fib(n-1)` and `fib(n-2)` multiple times can be avoided by storing their results.<br><br>

<strong>2. Optimal Substructure</strong><br>
A problem has optimal substructure if its solution can be built from solutions of its subproblems.<br>
Example: Finding the shortest path from `A` to `C` via `B` involves combining the shortest paths from `A` to `B` and `B` to `C`.<br><br>

---

<h3>Steps to Solve a DP Problem</h3>

1. <strong>Define the State</strong><br>
   A "state" represents a subproblem.<br>
   Example: In the Fibonacci problem, `dp[n]` stores the `n`th Fibonacci number.<br><br>

2. <strong>Recurrence Relation</strong><br>
   The formula to calculate the current state using previous states.<br>
   Example: `dp[n] = dp[n-1] + dp[n-2]`.<br><br>

3. <strong>Base Cases</strong><br>
   These are the smallest subproblems with known solutions.<br>
   Example: `dp[0] = 0`, `dp[1] = 1`.<br><br>

4. <strong>Solve the Problem</strong><br>
   Compute the result iteratively or recursively while storing intermediate results.<br><br>

---

<h3>Real-World Analogy</h3>

Imagine climbing stairs, where you can take 1 or 2 steps at a time. How many ways can you reach the top of a staircase with `n` steps?<br><br>

<h4>Steps:</h4>

1. <strong>State</strong>: Let `dp[i]` represent the number of ways to reach the `i`th step.<br>
2. <strong>Recurrence Relation</strong>:<br>
   - To reach step `i`, you could:
     - Come from step `i-1` (1 step).<br>
     - Come from step `i-2` (2 steps).<br>
   - Formula: `dp[i] = dp[i-1] + dp[i-2]`.<br><br>

3. <strong>Base Cases</strong>:<br>
   - `dp[0] = 1` (1 way to stay at the ground).<br>
   - `dp[1] = 1` (1 way to reach the first step).<br><br>

4. <strong>Solve</strong>:<br>
   Fill the `dp` array from `0` to `n` to compute `dp[n]`.<br><br>

---

<h3>Types of DP</h3>

1. <strong>Top-Down (Memoization)</strong><br>
   Solve the problem recursively and store the results of subproblems to avoid redundant work.<br>
   Example: Recursive Fibonacci with caching.<br><br>

2. <strong>Bottom-Up (Tabulation)</strong><br>
   Start solving from the smallest subproblems and build up to the final solution using a table.<br>
   Example: Iterative Fibonacci using an array.<br><br>

---

<h3>Example Problem: Fibonacci Numbers</h3>

<h4>Problem:</h4>
Find the `n`th Fibonacci number where:<br>
- `fib(0) = 0`<br>
- `fib(1) = 1`<br>
- `fib(n) = fib(n-1) + fib(n-2)` for `n > 1`.<br>



