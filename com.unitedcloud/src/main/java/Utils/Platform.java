package main.java.Utils;

public enum Platform {

    WEB_DESKTOP("webDesktop");

    private String value;

    Platform(String value){this.value = value;}

    @Override
    public String toString() {
        return value;
    }
}
