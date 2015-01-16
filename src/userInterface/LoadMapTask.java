
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.SwingWorker;


public class LoadMapTask extends SwingWorker<BufferedImage, Object> {

        private String latitude;
        private String longitude;
        private MapPane mapPane;
        private JButton master;

        public LoadMapTask(JButton master, MapPane mapPane, String latitude, String lonitude) {
            this.mapPane = mapPane;
            this.latitude = latitude;
            this.longitude = lonitude;
            this.master = master;
        }

        @Override
        protected BufferedImage doInBackground() throws Exception {
            BufferedImage mapImage = null;
            try {
                URL map = new URL("http://maps.google.com/staticmap?center=" + latitude + "," + longitude + "&zoom=5&size=500x500");
                System.out.println(map);
                mapImage = ImageIO.read(map);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
            return mapImage;
        }

        @Override
        protected void done() {
            try {
                mapPane.setMap(latitude, longitude, get());
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
            master.setEnabled(true);
        }

    }


