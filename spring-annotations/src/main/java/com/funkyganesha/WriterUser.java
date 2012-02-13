package com.funkyganesha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriterUser {
    private Writer writer;

    @Autowired
    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public static void main(String[] Heyday) {
        String str = "Hello World";
        new WriterUser().writer.write(str);
    }
}
