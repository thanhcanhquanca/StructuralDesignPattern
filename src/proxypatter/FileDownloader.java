package proxypatter;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader implements Downloader {
    private String userAgent;

    public FileDownloader(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public void download(String fileUrl, String destinationPath) throws Exception {
        URL url = new URL(fileUrl);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", userAgent);

        try (InputStream inputStream = new BufferedInputStream(connection.getInputStream());
             FileOutputStream fileOutputStream = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        }

        System.out.println("Download completed: " + destinationPath);
    }
}
