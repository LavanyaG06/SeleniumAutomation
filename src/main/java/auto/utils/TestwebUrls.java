package auto.utils;

public enum TestwebUrls {
    test("www.google.com"),
    dev("www.amazon.com");
    private final String url;
    TestwebUrls(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
}
