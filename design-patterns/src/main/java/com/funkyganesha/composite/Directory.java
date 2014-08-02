package com.funkyganesha.composite;


import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by barga009 on 8/2/14 at 12:42 AM. Comment {"$EXPR$"}
 */
public class Directory implements AbstractFile {

    private String directoryName;
    private List<Object> directory = Lists.newArrayList();
                                                          private boolean isDirectory;

    public boolean isDirectory() {
        return isDirectory;
    }

    public Directory(String directoryName) {
        this.directoryName = directoryName;
    }

    public void addIntoDirectory(Object o) {
        if (!directory.contains(o)) {
            directory.add(o);
        }
    }

    public void removeFromDirectory(Object o) {
        if (directory.contains(o)) {
            directory.remove(o);
        }
    }

    @Override
    public void ls() {
        java.io.File file = new java.io.File(directoryName);
        System.out.println(file.list());
        isDirectory = file.isDirectory();
    }
}
