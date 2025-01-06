package proxypatter;

public class FileDownloaderProxy implements Downloader {
    private FileDownloader fileDownloader;

    public FileDownloaderProxy() {
        // Khởi tạo với User-Agent của trình duyệt Firefox
        this.fileDownloader = new FileDownloader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Firefox/112.0");
    }

    @Override
    public void download(String fileUrl, String destinationPath) throws Exception {
        // Chuyển lời gọi đến đối tượng FileDownloader
        fileDownloader.download(fileUrl, destinationPath);
    }
}
