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

public class LocateApple extends Data {
    public void locateApple(){
        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * Storage.DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * Storage.DOT_SIZE));
    }
}
