package main.services;

public enum EndPoints {
    LOGIN("http://localhost:81/v1.0/usuario/auth"),
    POINTS("http://localhost:8282/v1.0/puntos"),
    DEMAND("http://localhost:80/v1.0/informes/demanda/");

    private final String url;

    EndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
