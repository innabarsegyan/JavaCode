package app;


public class Bowl {
    private final String maker;
    private final Size size;

    public Bowl(String maker, Size size) {
        this.maker = maker;
        this.size = size;
    }

    public String getMaker() {
        return maker;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Производитель: " + maker + "." + " Размер: " + size;
    }

    public enum Size {
        S,
        M,
        L,
        ;
    }
}