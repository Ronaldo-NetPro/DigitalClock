
package javaapplication1;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/*
*
**@author RONALDO TSETSEWA
*
*/
public class DigitalClock extends JFrame {
    private JLabel timeLabel;
    private volatile boolean running = true;

    public DigitalClock() {
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 50));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timeLabel);

        setTitle("Digital Clock");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void startClock() {
        Thread timeThread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            while (running) {
                
                String currentTime = sdf.format(new Date());
                //Date date = new Date();
                //currentTime = sdf.format(date);
                
                timeLabel.setText(currentTime);
                try {
                    Thread.sleep(1000); // Update every second
                } catch (InterruptedException e) {
                    System.out.println("" + e.getMessage());
                }
            }
        });

        timeThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DigitalClock clock = new DigitalClock();
            clock.setVisible(true);
            clock.startClock();
        });
    }
}

