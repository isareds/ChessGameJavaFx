/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import javafx.scene.image.Image;
import util.ChessUtil;

/**
 *
 * @author newto
 */
public class ChessPawn extends Image implements ChessUtil{
    
    private int x,y;
    
    
    public ChessPawn(String url) {
        super(url);
    }

    public ChessPawn(String url, int x, int y){
        super(url);
        this.x = x;
        this.y = y;
    }

        
    private String setRoleBaseOnCoordinates(){
        String url = null;
        
        if( this.x >= 1 && this.x <=2){
            switch(x){
                case 2 : url = "./images/pedone-white.svg";
            }
        }
        
        return url;
    }
    
    
    @Override
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getCoordinates() {
        return "(" + this.x + "," + this.y + ")";
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
   
}
