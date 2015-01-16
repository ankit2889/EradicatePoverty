
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class TestGoogleMaps {

    public static void main(String[] args) {
        new TestGoogleMaps();
    }

    public TestGoogleMaps() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                final MapPane mapPane = new MapPane();
                JButton random = new JButton("Random");
                random.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String lat = Double.toString((Math.random() * 180) - 90);
                        String longt = Double.toString((Math.random() * 360) - 180);
                        new LoadMapTask((JButton)e.getSource(), mapPane, lat, longt).execute();
                        ((JButton)e.getSource()).setEnabled(false);
                    }
                });

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(mapPane);
                frame.add(random, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
        
    }
    
}
    
 
