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
import java.util.Collections;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author Lenovo
 */
interface Array {
    A[] num;
    public Array();
         
    public void Add(A number, int index){
        num[index] = number;
    }

    public A Get(int index){
        return num[index];
    }        
}
