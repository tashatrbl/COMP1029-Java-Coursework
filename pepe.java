import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;

public class pepe {
  public static void main(String[] argv) throws Exception {
    JFrame myJFrame = new JFrame();
    Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello World");
                myJFrame.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
          System.out.println("Up Arrrow-Key is pressed!");
          System.exit(0);
        }
        else if (keyCode == KeyEvent.VK_DOWN) {
          System.out.println("Down Arrrow-Key is pressed!");
        }
        else if (keyCode == KeyEvent.VK_LEFT) {
          System.out.println("Left Arrrow-Key is pressed!");
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
        System.out.println("Right Arrrow-Key is pressed!");
        }
      }
    });
            }
        };

        // Schedule the task to run every second
        timer.schedule(task, 0, 1000);
    
    

    myJFrame.setVisible(true);
  }
}

