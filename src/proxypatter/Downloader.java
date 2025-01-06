package proxypatter;

public interface Downloader {
    void download(String fileUrl, String destinationPath) throws Exception;
}

