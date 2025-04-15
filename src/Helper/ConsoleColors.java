package Helper;

@SuppressWarnings("unused")
public class ConsoleColors {
    public static final String RESET = "\033[0m";
    public static final String BLACK = "\033[30m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String MAGENTA = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String WHITE = "\033[37m";

    public static final String BG_RED = "\033[41m";
    public static final String BG_GREEN = "\033[42m";
    public static final String BG_YELLOW = "\033[43m";
    public static final String BG_BLUE = "\033[44m";

    public static final String BOLD = "\033[1m";
    public static final String UNDERLINE = "\033[4m";

    public static void success(String msg) {
        System.out.println(GREEN + "✅ " + msg + RESET);
    }

    public static void error(String msg) {
        System.out.println(RED + "❌ " + msg + RESET);
    }

    public static void warning(String msg) {
        System.out.println(YELLOW + "⚠️  " + msg + RESET);
    }

    public static void info(String msg) {
        System.out.println(CYAN + "ℹ️  " + msg + RESET);
    }

    public static void headline(String msg) {
        System.out.println(BOLD + BLUE + msg + RESET);
    }
}
