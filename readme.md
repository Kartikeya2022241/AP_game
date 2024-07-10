1. Open the terminal.

2. Run the following commands in sequence:

   ```sh
   mvn clean
   mvn compile
   mvn package
3. Change directory to target:
   ```cd target```
4. Run the program with the following command, replacing C:\Users\leech\Downloads\openjfx-21.0.1_windows-x64_bin-sdk\javafx-sdk-21.0.1\lib with your Java SDK lib path:
    ```java --module-path "C:\Users\leech\Downloads\openjfx-21.0.1_windows-x64_bin-sdk\javafx-sdk-21.0.1\lib" --add-modules javafx.controls,javafx.fxml -jar .\demo1-1.0-SNAPSHOT.jar```
5. The program will ask you to register or login. Even if you close the game, the user is still stored, and the next time you open the game, you can simply login.

6. After successful login, you can play the game by clicking on the play button. The cherry icon will show you how many cherries you have collected, and the leaderboard option will display the top 3 scorers.

7. Once you press the play button, the game starts. Mouse click for a particular time increases the length of the rod, and when you release it, it will rotate and fall down. If it lands on the width of the destination tower, the player moves forward; otherwise, the player falls. While moving, the player can collect cherries by pressing the space bar at the exact time where the cherry is located.

8. The screen has a pause button where you can save the state of the game. You can then see the resume button on the first screen.

9. If you fall, a third screen will appear with the options: play again, home, and see leaderboard.

10. Clicking on the play again button restarts the game.
11. Clicking on the home button takes you to the first screen.
12. Clicking on the leaderboard button will show you the leaderboard.

Thank you,
Kartikeya 2022241
Aahan Piplani 2022001
