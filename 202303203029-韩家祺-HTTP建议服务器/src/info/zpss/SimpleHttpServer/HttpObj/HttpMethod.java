package info.zpss.SimpleHttpServer.HttpObj;

public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    HEAD("HEAD"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE"),
    CONNECT("CONNECT");
    /**
     * 这是一个Java枚举类型，定义了HTTP协议中支持的请求方法，
     * 包括GET、POST、PUT、DELETE、HEAD、OPTIONS、TRACE和CONNECT。
     * 每个请求方法都有一个对应的字符串名称和一个方法来获取其名称。
     * 此外，这个枚举类型还定义了一个静态方法fromString，
     * 用于将字符串类型的请求方法名称转换为对应的HttpMethod枚举值。
     */
    private final String name;

    HttpMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static HttpMethod fromString(String name) {
        for (HttpMethod method : HttpMethod.values())
            if (method.name.equalsIgnoreCase(name))
                return method;
        return null;
    }
}
