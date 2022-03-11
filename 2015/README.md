# [Advent of Code 2015](https://adventofcode.com/2015)

This repository stores my solutions of Advent of Code 2015.


## [Day 1](https://adventofcode.com/2015/day/1)

Part 1: Just count opening and closing brackets.

Part 2: Count again and stop on condition.


## [Day 2](https://adventofcode.com/2015/day/2)

Part 1: Calculate required wrapping paper.

Part 2: Calculate required ribbon.


## [Day 3](https://adventofcode.com/2015/day/3)

Part 1: Count visited positions.
This exercise is much simpler if you use a separate class for the position (aka House).

Part 2: Count visited positions for different walker.


## [Day 4](https://adventofcode.com/2015/day/4)

Part 1: Search a MD5 sum in hex format and starts with five zeros (00000). 

Part 2: Search a MD5 sum in hex format and starts with six zeros (000000).

## [Day 5](https://adventofcode.com/2015/day/5)

Part 1:  

Part 2: 

## [Day 6](https://adventofcode.com/2015/day/6)

Part 1:  

Part 2: 

## [Day 7](https://adventofcode.com/2015/day/7)

Part 1:  

Part 2: 

## [Day 8](https://adventofcode.com/2015/day/8)

Part 1: Find the shortest path to visit all locations. ([NP complete problem](https://en.wikipedia.org/wiki/NP-completeness))

Solution idea: Brute force approach
* Full search using a recursive algorithm.
* Termination conditions: all locations visited and all possible path checked

Remark: search duration not considered, since only few locations

Part 2: 

## [Day 9](https://adventofcode.com/2015/day/9)

Part 1:

Part 2: 

## [Day 10](https://adventofcode.com/2015/day/10)

Part 1:

Part 2: 

## [Day 11](https://adventofcode.com/2015/day/11)

Part 1:

Part 2: 

## [Day 12](https://adventofcode.com/2015/day/12)

Part 1:

Part 2: 

## [Day 13](https://adventofcode.com/2015/day/13)

Part 1:

Part 2: 

## [Day 14](https://adventofcode.com/2015/day/14)

Part 1:

Part 2: 

## [Day 15](https://adventofcode.com/2015/day/15)

Part 1:

Part 2: 

## [Day 16](https://adventofcode.com/2015/day/16)

Part 1:

Part 2: 

## [Day 17](https://adventofcode.com/2015/day/17)

Part 1:

Part 2: 

## [Day 18](https://adventofcode.com/2015/day/18)

Part 1:

Part 2: 

## [Day 19](https://adventofcode.com/2015/day/19)

Part 1:

Part 2: 

## [Day 20](https://adventofcode.com/2015/day/20)

### Solution strategy

The elves deliver the presents to houses.
The number of presents depends on the house number.
From mathematical perspective the number of presents is a function of the house number.
The problem of this function is that it isn't steadily increasing, therefore the search must be incremental.
In other words from mathematical perspective it's hard to implement a target value search.

My first approach was to start with the square root of a tenth of the number of presents.
Unfortunately this approach is quite rough and doesn't reduce the runtime significantly.
My second approach was to implement the search multithreaded.
This approach depends on the number of available cores and leads to a significant reduction of the runtime.

### Single-Thread

| House   | Presents   |
|---------|------------|
| 1       | 10         |
| 2       | 30         |
| ..      | ..         |
| 776,160 | 33,100,000 | 

### Multi-Thread (e.g. 4 Threads)

| #   | House (1) | Presents (1) | House (2) | Presents (2) | House (3) | Presents (3) | House (4) | Presents (4) |
|-----|-----------|--------------|-----------|--------------|-----------|--------------|-----------|--------------|
| 1   | 1         | 10           | 2         | 30           | 3         | 40           | 4         | 70           |
| 2   | 5         | 60           | 6         | 120          | 7         |              | 8         |              |
| 3   | ..        | ..           | ..        | ..           | ..        | ..           | ..        | ..           |
 | 4   | 776,157   | ..           | 776,158   | ..           | 776,159   | ..           | 776,160   | 33,100,000   |

There is no race condition that all threads process the same number of elements.

### Results

Part 1:
776,160

Part 2:
786,240

## [Day 21](https://adventofcode.com/2015/day/21)

Part 1:

Part 2: 

## [Day 22](https://adventofcode.com/2015/day/22)

Part 1:

Part 2: 

## [Day 23](https://adventofcode.com/2015/day/23)

Part 1:

Part 2: 

## [Day 24](https://adventofcode.com/2015/day/24)

Part 1:

Part 2: 

## [Day 25](https://adventofcode.com/2015/day/25)

Part 1:

Part 2: 
