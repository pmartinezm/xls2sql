public class Coordenada {
    public int r, c;

    public Coordenada(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return this.r + ":" + this.c;
    }
}
