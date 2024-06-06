/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class Clock extends Thread{
    private JLabel lbl;

    public Clock(JLabel lbl) {
        this.lbl = lbl;
    }

    public void run() {
        while (true) {
            try {
                Date date = new Date();
                String time = Modify.Utility.getTimeNow("M/dd/yyyy - HH:mm:ss");

                lbl.setText(time);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
