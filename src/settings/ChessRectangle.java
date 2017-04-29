/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author newto
 */
public class ChessRectangle extends Rectangle {
    
    private boolean emptyBox = false;
    
    public boolean isEmpty(){
        return (this.emptyBox);
    }

    /**
     * @param emptyBox the emptyBox to set
     */
    public void setEmptyBox(boolean emptyBox) {
        this.emptyBox = emptyBox;
    }
   
}
