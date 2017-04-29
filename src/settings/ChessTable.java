/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import util.PawnsSettings;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author newto
 */
public class ChessTable{
    
    private Color odd;
    private Color peer;
    
    private final int GRID_SIZE_VALUE = 8;
    private ChessGrid rootGridPane;
    
    public ChessTable(){
        System.out.println("Init ChessTable");
    };
    
    
    public GridPane generateChessTable(){
        System.out.println("Generata nuova tabella");
        rootGridPane = new ChessGrid();
        
        
        rootGridPane.setGridLinesVisible(true);
        rootGridPane.setAlignment(Pos.CENTER);
        rootGridPane.setPrefSize(650, 650);
        //rootGridPane.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        rootGridPane.setMaxSize(700, 700);
        
        
        for(int row = 1; row <= GRID_SIZE_VALUE; row++){
                    
            for(int column = 1; column <= GRID_SIZE_VALUE; column++){
                String stringColumn = Integer.toString(column);
                String stringRow = Integer.toString(row);


                Color squareBackgroundColor;
                if(((row + column) % 2) == 0) {
                    if(this.odd == null){
                        squareBackgroundColor = Color.SIENNA;
                    }else{
                        squareBackgroundColor = this.odd;
                    }
                    
                } else {
                    if(this.peer == null){
                        squareBackgroundColor = Color.BEIGE;
                    }else{
                        squareBackgroundColor = this.peer;
                    }
                    
                }
                
                ChessStackPane stackPane = new ChessStackPane();
                stackPane.setCoordinates(row, column);
                
                ChessRectangle square = new ChessRectangle();
                square.setId(stringColumn + ":" + stringRow);
                square.setFill(squareBackgroundColor);
                square.setHeight(75);
                square.setWidth(75);
                /*
                square.widthProperty().bind(rootGridPane.widthProperty().divide(GRID_SIZE_VALUE));
                square.heightProperty().bind(rootGridPane.heightProperty().divide(GRID_SIZE_VALUE));
                */
                
                square.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event1) {
                        System.out.print("Clicked Square->");
                        System.out.print(" " + square.getId());
                        System.out.println(" " + square.isEmpty());
                        
                        if(rootGridPane.isInMovementModality() && square.isEmpty()){
                            //ChessPawn selectedPawn = rootGridPane.getMovingObject();
                            //selectedPawn.setChessPawnParentEmpty();
                            
                            Node node = square.getParent();
                            if(node instanceof ChessStackPane){
                                System.out.println("è un instanza");
                                ((ChessStackPane) node).getChildren().add(rootGridPane.getMovingObject());
                                rootGridPane.getMovingObject().abortMovementOperation();
                                System.out.println(rootGridPane.getMovingObject().getImage());
                            }else{
                                System.out.println(node);
                            }
                            
                            rootGridPane.stopMovement();
                        }
                     }
                });

                
                ChessPawn chessPawn = new ChessPawn(row, column);
                
                chessPawn.setId(stringRow + "," + stringColumn);
                chessPawn.setOnMousePressed(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        System.out.print("Clicked Pawn->");
                        System.out.println("" + chessPawn.getId());
                        
                        if(rootGridPane.isInMovementModality()){
                            System.out.println("Condition");
                            String alreadySelectedObject = rootGridPane.getMovingObjectId();
                            
                            System.out.println("Already selected object: " + alreadySelectedObject);
                            System.out.println("Pawn id: " + chessPawn.getId());
                            
                            if(alreadySelectedObject == chessPawn.getId()){
                                
                                chessPawn.abortMovementOperation();
                                rootGridPane.stopMovement();
                                
                            }else{
                               
                                rootGridPane.getMovingObject().abortMovementOperation();
                                rootGridPane.setMovingObject(chessPawn);
                                rootGridPane.setMovingObjectId(chessPawn.getId());
                                
                                chessPawn.selectForMovement();
                            }
                        }else{
                
                            rootGridPane.setInMovementModality();
                            rootGridPane.setMovingObjectId(chessPawn.getId());
                            rootGridPane.setMovingObject(chessPawn);
                            
                            chessPawn.selectForMovement();
                        }
                    }
                });
                
                
                if(row >= 1 && row <= 2){
                    Image pawn = PawnsSettings.setPawnRoleBaseOnCoordinates(row, column);
                    chessPawn.setImage(pawn);
                    
                    chessPawn.fitWidthProperty().bind(square.widthProperty());
                    chessPawn.fitHeightProperty().bind(square.heightProperty());
                    
                    stackPane.getChildren().addAll(square,chessPawn);
                }else if(row >= 7 && row <= 8){
                    Image pawn = PawnsSettings.setPawnRoleBaseOnCoordinates(row, column);
                    chessPawn.setImage(pawn);
                    
                    chessPawn.fitWidthProperty().bind(square.widthProperty());
                    chessPawn.fitHeightProperty().bind(square.heightProperty());
                    
                    stackPane.getChildren().addAll(square,chessPawn);
                }else{
                    
                    stackPane.getChildren().addAll(square);
                    square.setEmptyBox(true);
                }
                
                rootGridPane.add(stackPane, column, row);
            } 
        }
        return rootGridPane;
    }
    /**
     * @return the rootGridPane
     */
    public GridPane getRootGridPane() {
        return rootGridPane;
    }

    /**
     * @param rootGridPane the rootGridPane to set
     */
    public void setRootGridPane(ChessGrid rootGridPane) {
        this.rootGridPane = rootGridPane;
    }
    
    public void setBoxesColor(Color odd, Color peer){
        
        this.odd = odd;
        this.peer = peer;
    }
    
}
