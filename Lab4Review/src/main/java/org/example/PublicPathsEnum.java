package org.example;

public enum PublicPathsEnum {
    FILE_PATH("INSERT PATH HERE");

    private final String path;

    PublicPathsEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
