package util;

public class Debug {
    private static Debug debug;
    private boolean enabled = true;

    /**
     * Escribe un mensaje en la consola con la estructura: [Debug] msg.
     */
    public void write(Object msg) {
        this.consoleLog("[Debug] " + msg);
    }

    /**
     * Escribe un mensaje de error en la consola con la estructura: [Error] msg.
     */
    public void error(Object msg) {
        this.consoleError("[Error] " + msg);
    }

    /**
     * Escribe un mensaje en la consola con la estructura: [Degub] -- msg --.
     */
    public void title(Object msg) {
        this.consoleLog("[Debug] -- " + msg + " --");
    }
    
    /**
     * Escribe un mensaje en consola con la estructura: [Debug]    msg.
     * @param msg
     */
    public void entry(Object msg) {
    	consoleLog("[Debug]    " + msg);
    }
    
    /**
     * Escribe un mensaje en consola con la estructura: [Error]    msg.
     * @param msg
     */
    public void entryError(Object msg) {
    	consoleError("[Error]    " + msg);
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
