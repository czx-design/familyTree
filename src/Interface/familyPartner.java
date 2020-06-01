package Interface;

import javax.swing.*;

public class familyPartner extends JButton {
    int Bx,By;

    public familyPartner(String name){
        this.setText(name);
    }

    public void changeX(int i){
        Bx = i;
    }
    public void changeY(int i){
        By = i;
    }
}
