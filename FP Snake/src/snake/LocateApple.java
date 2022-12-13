/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package snake;

public class LocateApple extends Data implements Storage{
    public int r;
    public void Set(int[] loc, int idx, int num){
        loc[idx] = num;
    }
    
    public int Set(int[] loc, int index){
        return loc[index];
    }
    
    @Override
    public int locate(){
        r = (int) (Math.random() * RAND_POS); /*conversion*/
        return ((r * DOT_SIZE));
    }
}
