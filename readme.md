### OOFP Bonus Assignment
Hereby my bonus assignment for the course OOFP at Vrije Universiteit Amsterdam, which 
I finished with a 9.5, partially thanks to this bonus giving me 1.6 out of 2 points.

# Connect Four
A basic Connect Four game written in Scala using the Processing library.
Featuring a 2 player multiplayer mode and 3 levels of AI difficulty.

## About
The game connect four is a 2 player game, where each player puts a stone on the board, and it will fall
all the way down. When a player gets 4 of the same color in a row, they win the game!

### How to play
`./gradlew run` will compile the files and run the game.

The game offers 4 options. A 2 player mode called 1v1, where each player chooses their own option, and
3 AI modes. The AI's are implemented the same way, however each difficulty adds more steps into thinking
forward before making a move.

### The AI
The AI is the minimax algorithm with alpha-beta pruning. The way the minimax algorithm works is that it
will simulate choosing the best moves for both the AI and the player. The AI wants to maximize the score,
while the player wants to minimize the score.

Going through each option however can take a lot of time, especially if early on it's clear the path
isn't going to be chosen. Here is where alpha-beta pruning comes in. In short, a player will always
choose the lowest score, while the AI will always choose the highest score. This means when we go
from player to AI, we know the player is going to search the lowest score. If an AI step generates a
higher score, we can stop searching in that branch, as the AI is going to pick a higher score than
a different branch.

### The Heuristic
For the minimax algorithm, we have to give a score to the board. The way I build up the heuristic, is by
giving 10 points for each pair of 2 stones, 100 points for a row of 3 stones, and 10000 points if we can
make the game finish.

## Gameplay Video
https://video.vu.nl/media/ConnectFourAI%2B2Player/1_11sjdmkf
