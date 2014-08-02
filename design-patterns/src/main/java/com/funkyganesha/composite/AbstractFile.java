package com.funkyganesha.composite;

/**
 * Created by barga009 on 8/2/14 at 12:38 AM.
 * Clients do not care if they are listing files or directories. The least common functionality is captured in the interface.
 */
public interface AbstractFile {
    void ls();
}
