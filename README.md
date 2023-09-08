# PoolTableGamePro

## How to run
- gradle run: to start
- gradle javadoc: to inspect the javadoc
    also the javadoc folder has all the javadoc

## Features
- Pockets and More Coloured Balls
- Difficulty Level
- Time and Score
- Undo and Cheat

## Design Pattern
- Memento:
    - Originator and Caretaker: GameManager
    - Memento: Memento
- Prototype:
    - Prototype: PocketStrategy
    - ConcretePrototype: BallStrategy, BlueStrategy, BrownStrategy
    - client: Ball
- Facade:
    - Facade: GameManager
    - client: App

## How to play
- select difficulty level: click the corresponding button on the initial page,
- reselect difficulty level: click "back to initial page" button to restart
- shot: click and drag your mouse, the length of the line is the power of the shot,
    then release your moues to fire
- undo a shot: click the undo button
    cannot undo after the game is won, but can undo after the game is lost.
- cheat: press the corresponding key to cheat
    (keycode:colour)  1:red  2:yellow  3:green  4:brown  5:blue  6:purple  7:black  8:orange
    (for example: press 1 to remove all red balls)
    (if there is no red ball, nothing will happen when press 1)
