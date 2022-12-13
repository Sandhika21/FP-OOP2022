/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package snake;

public class initGame extends LocateApple{

    @Override
    public void Set(int[] loc, int index, int number){
        loc[index] += number;
    }    
    
}
