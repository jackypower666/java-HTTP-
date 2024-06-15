package info.zpss.SimpleHttpServer.HttpObj;

public enum HttpContentType {
    TEXT_HTML("text/html"),
    TEXT_CSS("text/css"),
    TEXT_PLAIN("text/plain"),
    TEXT_JAVASCRIPT("text/javascript"),
    IMAGE_JPEG("image/jpeg"),
    IMAGE_PNG("image/png"),
    IMAGE_GIF("image/gif"),
    IMAGE_BMP("image/bmp"),
    IMAGE_X_ICON("image/x-icon"),
    IMAGE_SVG_XML("image/svg+xml"),
    IMAGE_WEBP("image/webp"),
    APPLICATION_JAVASCRIPT("application/javascript"),
    APPLICATION_OCTET_STREAM("application/octet-stream");
    /**
     * 这是一个Java枚举类型，定义了HTTP协议中支持的媒体类型，包含了一系列常见的文本、
     * 图像和应用程序类型。
     * 每个媒体类型都有一个对应的字符串名称和一个方法来获取其名称。
     * 此外，这个枚举类型还定义了一个静态方法fromString，
     * 用于从文件扩展名中获取对应的HttpContentType枚举值。
     * 在这个方法中，通过对文件扩展名进行switch-case判断，将文件扩展名转换为对应的媒体类型，如果没有对应项，则使用默认值TEXT_HTML。
     * 这个方法通常用于确定要在HTTP响应中使用的Content-Type头。
     */
    private final String name;

    HttpContentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static HttpContentType fromString(String extension) {
        switch (extension.toLowerCase()) {
            case "css":
                return TEXT_CSS;
            case "txt":
                return TEXT_PLAIN;
            case "js":
                return TEXT_JAVASCRIPT;
            case "jpg":
            case "jpeg":
                return IMAGE_JPEG;
            case "png":
                return IMAGE_PNG;
            case "gif":
                return IMAGE_GIF;
            case "bmp":
                return IMAGE_BMP;
            case "ico":
                return IMAGE_X_ICON;
            case "svg":
                return IMAGE_SVG_XML;
            case "webp":
                return IMAGE_WEBP;
            case "html":
            case "htm":
            default:
                return TEXT_HTML;
        }
    }
}
