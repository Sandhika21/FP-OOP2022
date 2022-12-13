/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package snake;

import java.util.HashMap;

public class Collection<T>{
    HashMap<T,T> cells;
    public Collection(){
        cells = new HashMap<>();
    }
    
    public void Add(T key, T value){
        cells.put(key, value);
    }
    
    public T GetK(T key){
        return cells.get(key);
    }
}
