package edu.isi.pegasus.planner.code.generator.json;

import java.util.List;
import java.util.Set;

public class Node {

    private final String id;
    private final List<String> requirements;
    private final Input input;
    private final String command;
    private final Set<String> input_files;
    private final Set<String> output_files;
    private final String directory;

    public Node(String id, List<String> requirements, Input input, String command, Set<String> input_files, Set<String> output_files, String directory) {
        this.id = id;
        this.requirements = requirements;
        this.input = input;
        this.command = command;
        this.input_files = input_files;
        this.output_files = output_files;
        this.directory = directory;
    }

    public String getId() {
        return id;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public Input getInput() {
        return input;
    }

    public String getCommand() {
        return command;
    }

    public Set<String> getOutput_files() {
        return output_files;
    }

    public Set<String> getInput_files() {
        return input_files;
    }

    public String getDirectory() {
        return directory;
    }
}
