package mx.uv.fiee.iinf.poo.demos.urlbasics;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main extends JFrame {
    private static final String LOREM_URL = "https://firebasestorage.googleapis.com/v0/b/departmentstorebackend.appspot.com/o/images%2Florem.txt?alt=media&token=83bfe244-d9fa-411d-879c-a7ca94dabed0";
    private TextArea myText;
    
    public Main() {
        setTitle("HTTP URL Connection");
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton urlConnButton = new JButton("Download with URLConnection");
        JButton httpClientButton = new JButton("Download with HttpClient");
        JButton asyncHttpButton = new JButton("Async Download with HttpClient");
        JButton okHttpButton = new JButton("Download with OkHttp");
        JButton clearButton = new JButton("Clear");

        buttonPanel.add(urlConnButton);
        buttonPanel.add(httpClientButton);
        buttonPanel.add(asyncHttpButton);
        buttonPanel.add(okHttpButton);
        buttonPanel.add(clearButton);

        myText = new TextArea();
        myText.setFont(new Font("Verdana", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(myText);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        urlConnButton.addActionListener(e -> {
            try {
                downloadWithURLConnection();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
        httpClientButton.addActionListener(e -> downloadWithHttpClient());
        asyncHttpButton.addActionListener(e -> downloadWithHttpClientAsync());
        okHttpButton.addActionListener(e -> downloadWithOkHttp());
        clearButton.addActionListener(e -> myText.setText(""));

        setContentPane(mainPanel);
        setVisible(true);
    }

    private void downloadWithURLConnection() throws InterruptedException {
        try {
            URL url = URI.create (LOREM_URL).toURL ();
            URLConnection urlConn = url.openConnection();
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) urlConn;
            httpUrlConn.connect();

            if (httpUrlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (InputStream in = httpUrlConn.getInputStream();
                     InputStreamReader inputStreamReader = new InputStreamReader(in, StandardCharsets.UTF_8);
                     BufferedReader buffReader = new BufferedReader(inputStreamReader)) {

                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = buffReader.readLine()) != null) {
                        builder.append(line).append("\n");
                    }

                    myText.setText(builder.toString());
                }
            }
            httpUrlConn.disconnect();
        } catch (IOException e) {
            myText.setText("Error: " + e.getMessage());
        }
    }

    private void downloadWithHttpClient() {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder (URI.create (LOREM_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                myText.setText(response.body());
            } else {
                myText.setText("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            myText.setText("Error: " + e.getMessage());
        }
    }

    private void downloadWithHttpClientAsync() {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder (URI.create (LOREM_URL))
                .GET()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(s -> myText.setText(s))
                .exceptionally(throwable -> {
                    myText.setText("Error: " + throwable.getMessage());
                    return null;
                });
    }

    private void downloadWithOkHttp() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(LOREM_URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                myText.setText(response.body().string());
            } else {
                myText.setText("Error: " + response.code());
            }
        } catch (IOException e) {
            myText.setText("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
