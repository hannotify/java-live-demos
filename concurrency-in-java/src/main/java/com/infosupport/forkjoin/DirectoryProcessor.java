package com.infosupport.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DirectoryProcessor extends RecursiveTask<List<File>> {
    private final File rootDir;
    private final String fileExtension;

    public DirectoryProcessor(File rootDir, String fileExtension) {
        this.rootDir = rootDir;
        this.fileExtension = fileExtension;
    }

    @Override
    protected List<File> compute() {
        var directoryProcessors = new ArrayList<DirectoryProcessor>();

        // small problem - current directory
        var filesWithExtension = rootDir.listFiles((dir, name) -> name.toLowerCase().endsWith(fileExtension));
        var files = new ArrayList<>(Arrays.asList(filesWithExtension));

        // fork
        var subDirs = rootDir.listFiles(File::isDirectory);

        for (File subDir : subDirs) {
            DirectoryProcessor directoryProcessor = new DirectoryProcessor(subDir, fileExtension);
            directoryProcessor.fork();
            directoryProcessors.add(directoryProcessor);
        }

        // join
        directoryProcessors.forEach(dp -> files.addAll(dp.join()));

        return files;
    }
}
