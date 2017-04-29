/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 *
 * @author newto
 */
public class ChessPawn extends ImageView {

    private int x,y;
    
    private boolean selectForMovement;
    
    
    public ChessPawn(int x, int y){
        setCoordinates(x, y);
    }
    
    private void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String getCoordinates() {
        return "(" + this.x + "," + this.y + ")";
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getXCoordinate() {
        return this.x;
    }

    public int getYCoordinate() {
       return this.y;
    }
    
    public void selectForMovement(){
        this.selectForMovement = true;
        
        super.setOpacity(0.7);
    }
    
    public void setChessPawnParentEmpty(){
        ChessStackPane parent = (ChessStackPane) super.getParent();
        ObservableList<Node> child = parent.getChildren();
        
        for(Node node : child){
            if(node instanceof ChessRectangle){
               //parent.getChildren().remove(1);
               ((ChessRectangle) node).setEmptyBox(true);
                System.out.println("Fatto");
            }
        }
    }
    
    public void abortMovementOperation(){
        super.setOpacity(0.0);
        this.selectForMovement = false;
    } 
    
    public boolean isSelectForMovement(){
        return this.selectForMovement;
    }
}