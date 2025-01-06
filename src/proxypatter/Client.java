package proxypatter;

public class Client {
    public static void main(String[] args) {
        Downloader downloader = new FileDownloaderProxy();
        String fileUrl = "https://example.com/sample-file.txt"; // Thay bằng URL thực tế
        String destinationPath = "sample-file.txt";

        try {
            downloader.download(fileUrl, destinationPath);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

