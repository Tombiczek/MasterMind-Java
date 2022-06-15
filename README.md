# MasterMind Java
This is a MasterMind game written in Java, for a uni project.


# How to use the game
Please, before changing the game mode, especially mid-game, do
remember to press reset button in the main menu.
Occasionally [Exception in thread "AWT-EventQueue-0" java.util.ConcurrentModificationException]
will show in the console. It doesn't affect the gameplay, and
I have not yet found the reason for it. If you find the way to
fix it before me, go ahead, but I recommend to not bother.



# Visuals
This is the main menu of the game. You have two levels of difficulty to
choose from, option to read the instructions [Polish], reset the game
or quit.
![Alt text](resources/menu.png?raw=true "Menu")



After you press the 'Play' button you will see the following image.
The game will not start until you press Q W E R or A S D F. Time: null
is an indicator of a game not yet started.
![Alt text](resources/play.png?raw=true "Menu")



Screenshot below shows in game interface. When the game is started
you will see the running time in the top right corner. After you
win or loose the game the time will stop. Please be aware that
times are not being saved yet, so in order to compare yourself, 
you should write it down before quiting the game.

![Alt text](resources/playtime.png?raw=true "Menu")



# Instructions [English]
Guess the hidden code!

Mastermind is a puzzle board game invented in 1970 by Mordechai 
Meirowitz, an Israeli postmaster and telecommunications expert.

Your task is to find a hidden code consisting of four colors. 
You can select the colors by pressing Q W E R (also A S D F), 
and confirm your choice with the SPACE key. On the left side 
displays the number of colors in the right position, and on the 
right side, the number of well-chosen colors in the wrong position. 
You have 12 tries, with each next one you are getting closer to 
finding the right combination!

Having trouble guessing the code?
Try 'Easy' mode, where the colors of the combination cannot be 
repeated.

# Instructions [Polish]
![Alt text](resources/instructions.png?raw=true "Instructions")

# Improvements
This game is fully completed however it could use some
improvements in the future. In the future I want to make
the count of the right colors and right colors in the wrong positions
appear next to the current row player is at. 
I will want to add automatic time saving mechanism and a 
leaderboard. Optional are mid-game backup and third game mode
allowing for one player to choose the combination and the
other one to guess it.

# Credits
To build this game I mainly followed Fatal Cubez's 2048 Tutorial
Series. 
https://www.youtube.com/playlist?list=PLig6-gM-fHMGH6jmCpsxW6YbagHgCS3Jd
It has many interesting ideas, so check it out.

# License
MIT License

Copyright (c) [2022] [Tomasz Lewinski]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

