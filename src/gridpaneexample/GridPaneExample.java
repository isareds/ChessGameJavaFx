/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridpaneexample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import settings.ChessMenu;
import settings.ChessPawn;
import settings.ChessTable;

/**
 *
 * @author newto
 */
public class GridPaneExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Start Game");
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                Stage secondaryStage = new Stage();
                secondaryStage.setResizable(false);
                
                ChessMenu chessMenu = new ChessMenu(secondaryStage);
                MenuBar menuBar = chessMenu.generateMenuBar();
                
                ChessTable chessTable = new ChessTable();
                chessTable.setBoxesColor(chessMenu.getOddBoxColor(), chessMenu.getPeerBoxColor());
                
                GridPane rootGridPane = chessTable.generateChessTable();
                
                VBox rootPane = new VBox();
                rootPane.getChildren().addAll(menuBar,rootGridPane);
                rootPane.setMargin(rootGridPane, new Insets(10));
                
                Scene gridPaneScene = new Scene(rootPane);
                
                
                secondaryStage.setTitle("Grid Pane Scene");
                secondaryStage.setScene(gridPaneScene);
                secondaryStage.show();
                
                primaryStage.close();
                
            }
        });
        
        Button imageViewTmp = new Button("Prova di imageView");
        imageViewTmp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage imageStage = new Stage();
                
                Image image = ChessPawn.setPawnRoleBaseOnCoordinates(2,1);
                ImageView imageView = new ImageView(image);
                
                StackPane root = new StackPane();
                root.getChildren().add(imageView);
                
                Scene imageScene = new Scene(root);
                imageStage.setScene(imageScene);
                imageStage.show();
            }
        });
        
        VBox root = new VBox();
        
        root.setPadding(new Insets(50));
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(btn,imageViewTmp);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Chess Settings");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
