# Dynamic-Programming
Dynamic Programming (DP) is a method in computer science used to solve complex problems by breaking them down into smaller, simpler problems. It is especially useful for problems that involve overlapping subproblems and optimal substructure.

<h2>Key Concepts of DP</h2>
</br>
<h3>1. Overlapping Subproblems</h3>
</br>
Some problems involve solving the same smaller problems repeatedly.
Instead of recalculating results for these subproblems every time, DP saves these results in a table (array, list, or map) and reuses them.
Example: Fibonacci Sequence

</br>
Calculating Fibonacci numbers involves repeatedly solving smaller subproblems like fib(n-1) and fib(n-2).
Using DP, you store the results of fib(1), fib(2), ..., fib(n-1) to avoid recalculating them.
</br>
<h3>2. Optimal Substructure</h3>
</br>
A problem has an optimal substructure if the solution to the problem can be constructed from the solutions of its subproblems.
In simpler terms, solving smaller parts of the problem helps solve the whole problem.
Example: Shortest Path

To find the shortest path from A to C via B, you need the shortest path from A to B and from B to C.


