package util;

public class Debug {
    private static Debug debug;
    private boolean enabled = true;

    /**
     * Writes a message in console with the structure: [Debug] msg.
     */
    public void write(Object msg) {
        this.consoleLog("[Debug] " + msg);
    }

    /**
     * Writes a red message in console with the structure: [Error] msg.
     */
    public void error(Object msg) {
        this.consoleError("[Error] " + msg);
    }

    /**
     * Writes a message in console with the structure: [Degub] -- msg --.
     */
    public void title(Object msg) {
        this.consoleLog("[Debug] -- " + msg + " --");
    }

    /**
     * Writes a message in console with the structure: [Debug] msg (ignored debug status).
     */
    public void writeIgnore(Object msg) {
        System.out.println("[Debug] " + msg + " (ignored debug status)");
    }

    /**
     * Writes a message in console with the structure: msg (ignored debug status).
     */
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
