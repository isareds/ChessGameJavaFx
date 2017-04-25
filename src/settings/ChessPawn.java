/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import javafx.scene.image.Image;
import java.nio.file.Paths;
import java.nio.file.Path;


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
        
        String preUrl = "file:///";
        String urlWithoutPawnName = preUrl + s +  "/resources/images/";
        
        if( x >= 1 && x <=2) {
           
            switch(x){
                case 1:{

                    switch(y){
                        case 1:
                            url = urlWithoutPawnName + "torre-white.png"; 
                            break;
                        case 8:
                            url = urlWithoutPawnName + "torre-white.png"; 
                            break;
                        case 2:
                            url = urlWithoutPawnName + "cavallo-white.png"; 
                            break;
                        case 7:
                            url = urlWithoutPawnName + "cavallo-white.png"; 
                            break;
                        case 3:
                            url = urlWithoutPawnName + "alfiere-white.png"; 
                            break;
                        case 6:
                            url = urlWithoutPawnName + "alfiere-white.png"; 
                            break;
                        case 4:
                            url = urlWithoutPawnName + "king-white.png"; 
                            break;
                        case 5:
                            url = urlWithoutPawnName + "queen-white.png"; 
                            break;
                    }
                    break;
                }
                
                case 2 : url = urlWithoutPawnName + "pedone-white.png"; break;
            }
        }else if( x >= 7 && x <= 8){
            
            switch(x){
                case 8:{
                    
                    switch(y){
                        case 1:
                            url = urlWithoutPawnName + "torre-black.png"; 
                            break;
                        case 8:
                            url = urlWithoutPawnName + "torre-black.png"; 
                            break;
                        case 2:
                            url = urlWithoutPawnName + "cavallo-black.png"; 
                            break;
                        case 7:
                            url = urlWithoutPawnName + "cavallo-black.png"; 
                            break;
                        case 3:
                            url = urlWithoutPawnName + "alfiere-black.png"; 
                            break;
                        case 6:
                            url = urlWithoutPawnName + "alfiere-black.png"; 
                            break;
                        case 4:
                            url = urlWithoutPawnName + "king-black.png"; 
                            break;
                        case 5:
                            url = urlWithoutPawnName + "queen-black.png"; 
                            break;
                    }
                    break;
                }
                case 7 : url = urlWithoutPawnName + "pedone-black.png"; break;
            }
        }else{
            throw new Error("No imaage found");
        }
        
        pawn = new Image(url);
        return pawn;
    }
}
