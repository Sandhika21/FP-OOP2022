/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package snake;

abstract public class Data implements Storage{  /*abstract class*/ 
         
    @Override
    public abstract int locate();
        
    public int Get(int[] loc, int index){
        return loc[index];
    }
}
