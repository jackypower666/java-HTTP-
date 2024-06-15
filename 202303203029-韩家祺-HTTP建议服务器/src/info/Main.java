import info.zpss.SimpleHttpServer.Arguable;
import info.zpss.SimpleHttpServer.SimpleHttpServer;

public class Main implements Arguable {
    public static final String VERSION = "1.0.0";
    public static void main(String[] args) {
        new Main().init(args);
        new Thread(() -> {
            SimpleHttpServer httpServer = SimpleHttpServer.getInstance();
            httpServer.init(args);
            httpServer.start();
        }).start();
    }
    @Override
    public void init(String[] args) {
        if (Arguable.paramInArgs(args, "-h", "--help")) {
            System.out.println("Usage: java -jar SimpleHttpServer.jar [options]");
            System.out.println("Options:");
            System.out.println("  -h, --help\t\t\tShow this help message and exit");
            System.out.println("  -v, --version\t\t\tShow version info and exit");
            System.out.println("  -H, --host <host>\t\tSpecify the server host like \"http://example.com\"");
            System.out.println("  -P, --port <port>\t\tSpecify the port to listen on");
            System.out.println("  -d, --dir <dir>\t\tSpecify the root directory");
            System.out.println("  -a, --absolute-dir <dir>\tSpecify the absolute root directory");
            System.exit(0);
        }
        /**
         *这是一个使用 SimpleHttpServer 库实现简单 HTTP 服务器的 Java 程序。在主函数中，先调用 Main 类的 init 方法解析传入的参数，并启动一个新线程启动 HTTP 服务器。而在 init 方法中，程序支持以下参数：
         *
         * - -h 或 --help：显示帮助信息并退出。
         * - -v 或 --version：显示程序版本信息并退出。
         * - -H 或 --host <host>：指定服务器主机，如"http://example.com"。
         * - -P 或 --port <port>：指定监听的端口号。
         * - -d 或 --dir <dir>：指定服务器的根目录。
         * - -a 或 --absolute-dir <dir>：指定服务器的绝对根目录。
         *
         * 如果解析到对应参数，则输出提示信息并将设置传递给 SimpleHttpServer 对象。最后，启动 HTTP 服务器。
         */
        if (Arguable.paramInArgs(args, "-v", "--version")) {
            System.out.printf("SimpleHttpServer v%s%n", VERSION);
            System.exit(0);
        }
        String dir = Arguable.stringInArgs(args, "-d", "--dir");
        if (dir != null) {
            System.out.println("Root directory: " + dir);
            SimpleHttpServer.getInstance().setRootDir(dir);
        }
        String absDir = Arguable.stringInArgs(args, "-a", "--absolute-dir");
        if (absDir != null) {
            System.out.println("Absolute root directory: " + absDir);
            SimpleHttpServer.getInstance().setAbsoluteRootDir(absDir);
        }
    }
}