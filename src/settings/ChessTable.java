/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
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
                            ChessCircle selectedCircle = rootGridPane.getMovingObject(); 
                            selectedCircle.setCircleParentAnEmptyBox();
                            stackPane.getChildren().add(selectedCircle);
                        }
                     }
                });

                /*
                ChessCircle  pawn = new ChessCircle();
                pawn.setCenterX(0);
                pawn.setCenterY(0);
                pawn.setRadius(25);
                pawn.setFill(Color.BLACK);
                pawn.setId(stringColumn + "," + stringRow);
                pawn.setCoordinates(row, column);
                pawn.setOnMousePressed(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        System.out.print("Clicked Circle->");
                        System.out.println("" + pawn.getId());
                        
                        if(rootGridPane.isInMovementModality()){
                            System.out.println("Condition");
                            String alreadySelectedObject = rootGridPane.getMovingObjectId();
                            
                            System.out.println("Already selected object: " + alreadySelectedObject);
                            System.out.println("Pawn id: " + pawn.getId());
                            
                            if(alreadySelectedObject == pawn.getId()){
                                System.out.println("ugualianza");
                                pawn.selectForMovement();
                                
                            }else{
                               
                                rootGridPane.getMovingObject().abortMovementOperation();
                                rootGridPane.setMovingObject(pawn);
                                rootGridPane.setMovingObjectId(pawn.getId());
                                
                                pawn.selectForMovement();
                            }
                        }else{
                            rootGridPane.setInMovementModality();
                            rootGridPane.setMovingObjectId(pawn.getId());
                            rootGridPane.setMovingObject(pawn);
                            
                            pawn.selectForMovement();
                        }
                        
                    }
                });
                */
                if(row == 2){
                    Image pawn = ChessPawn.setPawnRoleBaseOnCoordinates(row, column);
                    ImageView imageView = new ImageView(pawn);
                    imageView.fitWidthProperty().bind(square.widthProperty());
                    imageView.fitHeightProperty().bind(square.heightProperty());
                    
                    stackPane.getChildren().addAll(square,imageView);
                }else if(row == 7){
                    Image pawn = ChessPawn.setPawnRoleBaseOnCoordinates(row, column);
                    ImageView imageView = new ImageView(pawn);
                    imageView.fitWidthProperty().bind(square.widthProperty());
                    imageView.fitHeightProperty().bind(square.heightProperty());
                    
                    stackPane.getChildren().addAll(square,imageView);
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
