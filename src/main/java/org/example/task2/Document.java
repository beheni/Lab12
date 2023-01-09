package org.example.task2;

import lombok.Getter;
import lombok.Setter;

public abstract class Document {
    @Getter
    @Setter
    protected String gcsPath;
    public abstract String parse();
}
