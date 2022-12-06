/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package snake;

import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

interface Storage {
    final int B_WIDTH = 300;
    final int B_HEIGHT = 300;
    final int DOT_SIZE = 10;
    final int ALL_DOTS = 900;
    final int RAND_POS = 29;
    final int DELAY = 140;
    final boolean leftdirection = false;
    final boolean rightDirection = true;
    final boolean upDirection = false;
    final boolean downDirection = false;
    final boolean inGame = true;
    
    public void locate();
    
}
