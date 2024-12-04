package org.example;

/**
 * PublicPathsEnum class contains the public paths
 */
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
