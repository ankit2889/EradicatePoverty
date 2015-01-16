
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class MapPane extends JPanel {

        private BufferedImage mapImage;
        private String latitude;
        private String longitude;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        public void setMap(String lat, String log, BufferedImage image) {
            mapImage = image;
            latitude = lat;
            longitude = log;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (mapImage != null) {
                int x = (getWidth() - mapImage.getWidth()) / 2;
                int y = (getHeight() - mapImage.getHeight()) / 2;
                g.drawImage(mapImage, x, y, this);
                FontMetrics fm = g.getFontMetrics();
                g.drawString(latitude + "x" + longitude, 0, fm.getAscent());
            }
        }

    }
