package util;

public class Debug {
    private static Debug debug;
    private boolean enabled = true;

    public void write(Object msg) {
        this.consoleLog("[Debug] " + msg);
    }

    public void error(Object msg) {
        this.consoleError("[Error] " + msg);
    }

    public void title(Object msg) {
        this.consoleLog("[Debug] -- " + msg + " --");
    }

    public void write() {
        this.consoleLog("");
    }

    public void writeIgnore(Object msg) {
        System.out.println("[Debug[I]] " + msg);
    }

    public void writeIgnoreAnon(Object msg) {
        System.out.println(msg);
    }

    private void consoleLog(Object msg) {
        if (this.isEnabed()) {
            System.out.println(msg);
        }
    }

    private void consoleError(Object msg) {
        if (this.isEnabed()) {
            System.err.println(msg);
        }
    }

    public static Debug getDebug() {
        if (debug == null) {
            debug = new Debug();
        }
        return debug;
    }

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }

    public boolean isEnabed() {
        return this.enabled;
    }
}
