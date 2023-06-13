package ua.ithillel.jcf.function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickActionListener implements ActionListener  {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked");
    }
}
