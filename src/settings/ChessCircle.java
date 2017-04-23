/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import util.ChessUtil;

/**
 *
 * @author newto
 */
public class ChessCircle extends Circle implements ChessUtil{
    
    private boolean selectForMovement;
    private int x,y;
    private Color initialColor;
    
    public void selectForMovement(){
        this.initialColor = (Color) super.getFill();
        super.setFill(Color.RED);
        
        this.selectForMovement = true;
    }
    
    public void setCircleParentAnEmptyBox(){
        ChessStackPane tmp = (ChessStackPane) super.getParent();
        ObservableList<Node> child = tmp.getChildren();
        
        for(Node node : child){
            if(node instanceof ChessRectangle){
               ((ChessRectangle) node).setEmptyBox(true);
                System.out.println("Fatto");
            }
        }
    }
    
    public void abortMovementOperation(){
        super.setFill(initialColor);
    }
    
    public boolean isSelectForMovement(){
        return this.selectForMovement;
    }
    
    @Override
    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
        
        setTypeOfPawn();
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

    /**
     * @return the initialColor
     */
    public Color getInitialColor() {
        return initialColor;
    }
    
    private void setTypeOfPawn(){
        
        if(this.x == 2){
            super.setFill(Color.BLUE);
        }
    }
    
}

