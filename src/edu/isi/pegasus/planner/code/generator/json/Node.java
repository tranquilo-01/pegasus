package edu.isi.pegasus.planner.code.generator.json;

import java.util.List;

public class Node {

    private final String id;
    private final List<String> requirements;
    private final Input input;
    private final String command;
    private final String output_file;

    public Node(String id, List<String> requirements, Input input, String command, String output_file) {
        this.id = id;
        this.requirements = requirements;
        this.input = input;
        this.command = command;
        this.output_file = output_file;
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

    public String getOutput_file() {
        return output_file;
    }
}
