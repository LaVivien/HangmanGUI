# Hangman Game GUI

## Description

-	Create a Java window as shown in the below
-	At “North”: 2x1 GridLayout with 2 non-editable JTextField’s – one for the game key, the other for player’s guess
-	At “Center”: a canvas for drawing health level and game over message
-	Size: 500 x 500
-	Health level begins at 5
-	At each wrong guess, the health level decreases
-	The game ends when the health level is 0; displays game over message.
-	At “South”: 4x7 GridLayout with 27 JButtons (26 alphabets and 1 “New”)
-	Use a JButton array (or ArrayList) of the length of 26 for the alphabet buttons (not including “New” JButton)
-	JButtons are enabled/disabled automatically as the game progresses

![Alt text](https://github.com/lavivien-cs-projects/HangmanGUI/blob/master/hangman.jpg?raw=true "Title")


## The Game Key Generation:

-	Define an ArrayList<String> to hold the game keys (a word pool).
-	Add the provided list of words below into the word pool ArrayList
-	Generate a random number based on the size of the ArrayList, and use the random number as an index to get the game key from the word pool
```
communication
science
programming
language
difficulty
artificial
intelligence
attempts
screenshot
baseball
windows
learning
electronics
beautiful
internet
database
organization
application
network
friendly
validation
attempts
statistics
physics
chemistry
engineering
school
industry
revolution
progress
characters
heavily
graphics
```


