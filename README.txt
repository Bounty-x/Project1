Part 1

Running Time data and Graphs
https://docs.google.com/spreadsheets/d/1sefbX83yg8ch8WHA5etWqaOqlkRtTaukKrTynSHMeCI/edit?usp=sharing
Graph is also in the running time.png file

The results.txt will be wiped and recalculated everytime Test.java is ran.
Each algorithm uses a same copy of 10 test lists from 50,000 to 500,000 items in increments of +50,000 (random) items


Part2

speed: O(nlogn)

startInsert is the variable used around line 18 which decides when we move to our
quadratic sort.

space: O(startInsert) when n (size of subarray) is <= 1000, insertion sort will be used
which makes a copy of the array, this is the only time we allocate more space than constant

