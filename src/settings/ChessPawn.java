/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import javafx.scene.image.Image;
import java.nio.file.Paths;
import java.nio.file.Path;

import util.ChessUtil;

/**
 *
 * @author newto
 */
public class ChessPawn {
    

        
    public static Image setPawnRoleBaseOnCoordinates(int x, int y){
        Image pawn = null;
        String url = null;
        
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
        
        String preUrl = "file:///";
        String urlWithoutPawnName = preUrl + s +  "/resources/images/";
        
        System.out.println("Url without pawn name: " + urlWithoutPawnName);
        
        if( x >= 1 && x <=2) {
            System.out.println("Sono qui 1");
            switch(x){
                case 2 : url = urlWithoutPawnName + "pedone-white.png"; System.out.println("Case 2"); break;
                default: System.out.println("Deafault case"); break;
            }
        }else if( x >= 7 && x <= 8){
            System.out.println("sono qui 2");
            switch(x){
                case 7 : url = urlWithoutPawnName + "pedone-black.png"; System.out.println("case 7"); break;
                default: System.out.println("second default case"); break;
            }
        }else{
            System.out.println("sono nell'else");
        }
        
        pawn = new Image(url);
        System.out.println("Immagine caricata");
        
        return pawn;
    }
    
}
