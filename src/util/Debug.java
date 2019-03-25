package util;

import org.apache.poi.ss.formula.functions.T;

public class Debug {
    private static Debug debug;
    private boolean enabled = true;

    public void write(Object msg) {
        this.consoleLog("[Debug] " + msg);
    }

    public void error(Object msg) {
        this.consoleError("[Error] " + msg);
    }

    public void title(String msg) {
        this.consoleLog("[Debug] -- " + msg + " --");
    }

    public void write() {
        this.consoleLog("");
    }

    private void consoleLog(String msg) {
        if (this.isEnabed()) {
            System.out.println(msg);
        }
    }

    private void consoleError(String msg) {
        if (this.isEnabed()) {
            System.err.println(msg);
        }
    }

    public static Debug getDebug() {
        if (debug != null) {
            return debug;
        }
        return new Debug();
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
