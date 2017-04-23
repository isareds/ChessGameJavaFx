/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import javafx.scene.layout.StackPane;
import util.ChessUtil;

/**
 *
 * @author newto
 */
public class ChessStackPane extends StackPane implements ChessUtil {
    private int x,y;
    
    @Override
    public void setCoordinates(int x, int y){
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
