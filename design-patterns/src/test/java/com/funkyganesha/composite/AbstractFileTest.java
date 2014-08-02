package com.funkyganesha.composite;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static junit.framework.Assert.assertTrue;

/**
 * Created by barga009 on 8/2/14 at 12:52 AM. Comment {"$EXPR$"}
 */
public class AbstractFileTest {

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Test
    public void testLsOnFile() throws Exception {
        java.io.File testFile = folder.newFile("testFile");
        File file = new File(testFile.getAbsolutePath());
        file.ls();
        assertTrue("Should have been true", file.isFile());
    }

    @Test
    public void testLsOnDirectory() throws Exception {
        Directory directory = new Directory(System.getProperty("java.io.tmpdir"));
        directory.ls();
        assertTrue("Should have been true", directory.isDirectory());
    }
}
