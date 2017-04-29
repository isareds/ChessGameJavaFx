/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 *
 * @author newto
 */
public class ChessGrid extends GridPane {
    
    
    private boolean mode = false;
    private ChessPawn movingObject;
    private String movingObjectId;
    
    public void setInMovementModality(){
        this.mode = true;
    }
    
    public void setMovingObjectId(String id){
        this.movingObjectId = id;
    }
    
    public boolean isInMovementModality(){
        return this.mode;
    }
    
    public String getMovingObjectId(){
        return this.movingObjectId;
    }
    
    public ChessCircle searchCircleById(int x, int y, ChessGrid parentGrid){
        ChessStackPane stackPane = null;
        ChessCircle result = null;
        
        ObservableList<Node> childrens = parentGrid.getChildren();
        
        for(Node node : childrens){
            if(parentGrid.getRowIndex(node) == x && parentGrid.getColumnIndex(node) == y){
                System.out.println("Trovato");
                stackPane = (ChessStackPane) node;
                System.out.println("StackCoordinates: " + stackPane.getCoordinates());
            }
        }
        
        return (ChessCircle) result;
    }

    public void setMovingObject(ChessPawn movingObject) {
        this.movingObject = movingObject;
    }
    
    public ChessPawn getMovingObject(){
        return this.movingObject;
    }
    
    public void stopMovement(){
        this.movingObject = null;
        this.movingObjectId = null;
        this.mode = false;
        System.out.println("Fine del movimento");
    }
}
