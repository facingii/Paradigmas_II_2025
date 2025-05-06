package mx.uv.fiee.iinf.poo.demos.executorcallable.utils;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.concurrent.Callable;

public class HttpHandler implements Callable<String> {
    private final String url;
    @Override
    public String call() throws Exception {
        return download ()
                .orElseThrow(() -> new RuntimeException("Error downloading text"));
    }

    public HttpHandler (String url) {
        this.url = url;
    }

    private Optional<String> download ()  {
        try (HttpClient client = HttpClient
                .newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build ()) {

            HttpRequest request = HttpRequest
                    .newBuilder(new URI (this.url))
                    .GET()
                    .build();

            var response = client.send (request, HttpResponse.BodyHandlers.ofString (StandardCharsets.UTF_8));
            if (response.statusCode () == 200) {
                return Optional.of (response.body ());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}



