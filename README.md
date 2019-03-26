
# Conway's Game of Life
The universe of the Game of Life is an infinite, two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, alive or dead, (or populated and unpopulated, respectively). Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:
1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
See more about the game [here](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Examples_of_patterns)

This application is a basic implementation of Conway's Game of Life rules to find out the next generation. 

## Requirements 
* Java version 1.8 or later
* Maven version 3.6

## Run the Program

* Clone the project or download the zip version of project
* If you downloaded zip file then Unzip the project 
* Open the terminal
* Go to the project root directory
* Run the command 
  `mvn exec:java -Dexec.mainClass=org.gameoflife.App`

## Run the test 
* Clone the project or download the zip version of project
* If you downloaded zip file then Unzip the project 
* Open the terminal
* Go to the project root directory
* Run the command 
`mvn test`
