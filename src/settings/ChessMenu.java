/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author newto
 */
public class ChessMenu {
    
    Stage parentStage;
    private Color oddBoxColor;
    private Color peerBoxColor;
    private GridPane newGridPane;
    private ChessTable newChessTable;
    
    public ChessMenu(Stage parentStage){
        this.parentStage = parentStage;
    }
    
    public MenuBar generateMenuBar(){
        
        MenuBar menuBar = new MenuBar();
        Menu gridMenu = new Menu("Grid");
        
        MenuItem newGrid = new MenuItem("New Grid");
        MenuItem chooseChessSquareColorMenuItem = new MenuItem("Box Color");
        MenuItem exitMenuItem = new MenuItem("Close");
        
        EventHandler<ActionEvent> newGridEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuBar newMenuBar = generateMenuBar();
                VBox newRootPane = new VBox();
                
                newChessTable = new ChessTable();
                newChessTable.setBoxesColor(oddBoxColor, peerBoxColor);
                newGridPane = newChessTable.generateChessTable();
                
                newRootPane.setMargin(newMenuBar, new Insets(0,0,0,0));
                newRootPane.setMargin(newGridPane, new Insets(10));
                newRootPane.getChildren().addAll(newMenuBar,newGridPane);
                
                Scene newScene = new Scene(newRootPane);
                
                parentStage.setScene(newScene);
                parentStage.show();
            }
        };
        
        newGrid.setOnAction(newGridEvent);
        
        chooseChessSquareColorMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage temporaryStage = new Stage();
                temporaryStage.setTitle("Scegli il colore");
                
                ColorPicker oddColorPicker = new ColorPicker();
                oddColorPicker.setValue(Color.SIENNA);
                
                ColorPicker peerColorPicker = new ColorPicker();
                peerColorPicker.setValue(Color.BEIGE);
                
                Label oddColorLabel = new Label("Colore scelto: ");
                Label peerColorLabel = new Label("Colore scelto: ");
                
                Text oddColorText = new Text(oddColorPicker.getValue().toString());
                Text peerColorText = new Text(peerColorPicker.getValue().toString());
                
                oddColorPicker.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        setOddBoxColor(oddColorPicker.getValue());
                        oddColorText.setText(getOddBoxColor().toString());
                        System.out.println("Odd color choosen: " + getOddBoxColor());
                    }
                });
                
                peerColorPicker.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        setPeerBoxColor(peerColorPicker.getValue());
                        peerColorText.setText(getPeerBoxColor().toString());
                        System.out.println("Peer color choosen: " + getPeerBoxColor());
                    }
                });
                
                
                HBox oddColorSettingHbox = new HBox();
                oddColorSettingHbox.getChildren().addAll(oddColorPicker, oddColorLabel, oddColorText);
                oddColorSettingHbox.setSpacing(50);
                oddColorSettingHbox.setAlignment(Pos.CENTER);
                
                        
                HBox peerColorSettingHbox = new HBox();
                peerColorSettingHbox.getChildren().addAll(peerColorPicker, peerColorLabel, peerColorText);
                peerColorSettingHbox.setSpacing(50);
                peerColorSettingHbox.setAlignment(Pos.CENTER);
                
                
                Button updateColorsButton = new Button();
                updateColorsButton.setText("Aggiorna");
                updateColorsButton.setOnAction(newGridEvent);
               
                Button exitButton = new Button();
                exitButton.setText("Esci");
                exitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        temporaryStage.close();
                    }
                });
                
                VBox root = new  VBox();
                root.setAlignment(Pos.CENTER);
                root.setSpacing(20);
                root.getChildren().addAll(oddColorSettingHbox, peerColorSettingHbox, updateColorsButton, exitButton);
                
                Scene temporaryScene = new Scene(root,500,500);
                
                temporaryStage.setScene(temporaryScene);
                temporaryStage.setAlwaysOnTop(true);
                temporaryStage.show();
            }
        });
        
        exitMenuItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               parentStage.close();
            }
        });
        
        gridMenu.getItems().addAll(newGrid,chooseChessSquareColorMenuItem, exitMenuItem);
        menuBar.getMenus().add(gridMenu);
        
        
        return menuBar;
    }

    /**
     * @return the oddBoxColor
     */
    public Color getOddBoxColor() {
        return oddBoxColor;
    }

    /**
     * @param oddBoxColor the oddBoxColor to set
     */
    public void setOddBoxColor(Color oddBoxColor) {
        this.oddBoxColor = oddBoxColor;
    }

    /**
     * @return the peerBoxColor
     */
    public Color getPeerBoxColor() {
        return peerBoxColor;
    }

    /**
     * @param peerBoxColor the peerBoxColor to set
     */
    public void setPeerBoxColor(Color peerBoxColor) {
        this.peerBoxColor = peerBoxColor;
    }
    
}
