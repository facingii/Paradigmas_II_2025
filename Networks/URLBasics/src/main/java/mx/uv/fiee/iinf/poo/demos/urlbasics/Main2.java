package mx.uv.fiee.iinf.poo.demos.urlbasics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main2
{
    static String uri = "https://firebasestorage.googleapis.com/v0/b/departmentstorebackend.appspot.com/o/images%2F53405989488_380a600691.png?alt=media&token=f6eacae0-9a9b-4a96-97f8-093c8fc963fe";

    public static void main (String [] args) throws MalformedURLException, URISyntaxException {
        JFrame frame = new JFrame ();
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        BoxLayout layout = new BoxLayout (frame.getContentPane (), BoxLayout.Y_AXIS);
        frame.setLayout(layout);

        JPanel panel = new JPanel ();
        panel.setBackground (Color.lightGray);
        panel.setPreferredSize(new Dimension(400, 300));

        HttpClient client = HttpClient.newBuilder().build ();
        HttpRequest request = HttpRequest.newBuilder (URI.create (uri)).GET().build ();

        JButton btnSync = new JButton ("Download Image Sync");
        btnSync.addActionListener (v -> {
            try {
                Graphics2D graphics = (Graphics2D) panel.getGraphics ();
                BufferedImage image = ImageIO.read (URI.create (uri).toURL ());
                graphics.drawImage (image, 0, 0, panel.getWidth (), panel.getHeight (), null);
                graphics.dispose ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        });

        JButton btnReset = new JButton ("Reset Canvas");
        btnReset.addActionListener (v -> panel.repaint ());

        JButton btnAsync = new JButton ("Download Image Async");
        btnAsync.addActionListener(v -> {
            client.sendAsync (request, HttpResponse.BodyHandlers.ofByteArray ())
                    .thenApply (HttpResponse::body)
                    .thenAccept (data -> {
                        try {
                            DrawImage ((Graphics2D) panel.getGraphics (), 0, 0, panel.getWidth (), panel.getHeight(), data);
                        } catch (IOException e) {
                            e.printStackTrace();
                        };
                    });
        });

        frame.add( panel );
        frame.add( btnSync );
        frame.add( btnReset );
        frame.add( btnAsync );
        frame.setVisible (true);
    }

    private static void DrawImage (Graphics2D graphics, int start, int end, int width, int height, byte[] data) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream (data);
        BufferedImage image = ImageIO.read (bais);
        graphics.drawImage (image, start, end, width, height, null);
        graphics.dispose ();
    }
}
