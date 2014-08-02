package com.funkyganesha.composite;

/**
 * Created by barga009 on 8/2/14 at 12:41 AM. Comment {"$EXPR$"}
 */
public class File implements AbstractFile {

    private String fileName;

    private boolean isFile;

    public File(String fileName) {
        this.fileName = fileName;
    }

    public boolean isFile() {
        return isFile;
    }

    @Override
    public void ls() {
        System.out.println("Printing [" + fileName + "] details.");
        java.io.File file = new java.io.File(fileName);
        isFile = file.isFile();
    }
}
