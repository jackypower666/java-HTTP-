package info.zpss.SimpleHttpServer.HttpObj;

public enum HttpStatus {
    OK(200, "OK"),
    NO_CONTENT(204, "No Content"),
    PARTIAL_CONTENT(206, "Partial Content"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),
    SEE_OTHER(303, "See Other"),
    NOT_MODIFIED(304, "Not Modified"),
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable");
    /**
     * 这是一个Java枚举类型，定义了HTTP协议中支持的状态码，
     * 包括了常见的成功、客户端错误、服务器错误等类型的状态码。每个状态码都有一个对应的整数值和一个字符串类型的原因短语。此外，这个枚举类型还定义了一个静态方法fromCode，根据传入的整数状态代码返回对应的HttpStatus枚举值。在这个方法中，首先遍历所有的状态码，
     * 如果找到对应的状态，则返回此状态枚举值。如果没有找到，则根据状态码的第一位数字进行判断，返回对应的预定义枚举值，
     * 例如2开头的状态码返回OK枚举值，
     * 3开头的状态码返回MOVED_PERMANENTLY枚举值，
     * 4开头的状态码返回NOT_FOUND枚举值，其他状态码返回INTERNAL_SERVER_ERROR枚举值。
     * 这个方法通常用于确定在HTTP响应中使用的状态代码和原因短语。
     */
    private final int code;
    private final String reason;

    HttpStatus(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

    public static HttpStatus fromCode(int code) {
        for (HttpStatus status : HttpStatus.values())
            if (status.code == code)
                return status;
        int firstDigit = code / 100;
        if (firstDigit == 2)
            return OK;
        if (firstDigit == 3)
            return MOVED_PERMANENTLY;
        if (firstDigit == 4)
            return NOT_FOUND;
        return INTERNAL_SERVER_ERROR;
    }
}
