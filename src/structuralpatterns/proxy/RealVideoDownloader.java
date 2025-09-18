package structuralpatterns.proxy;

public class RealVideoDownloader implements VideoDownloader{
    @Override
    public String downloadVideo(String videoUrl) {
        System.out.println("Downloading video from URL: " + videoUrl);
        return "Video content from " + videoUrl;
    }
}
