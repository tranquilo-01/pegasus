package edu.isi.pegasus.planner.code.generator.json;

import java.util.List;
import java.util.Set;

public class Node {

    private final String id;
    private final List<String> exec;
    private final Set<String> input_files;
    private final Set<String> output_files;
    private final Set<String> requirements;

    public Node(String id, List<String> exec, Set<String> requirements, Set<String> input_files, Set<String> output_files) {
        this.id = id;
        this.requirements = requirements;
        this.exec = exec;
        this.input_files = input_files;
        this.output_files = output_files;
    }

    public String getId() {
        return id;
    }

    public Set<String> getRequirements() {
        return requirements;
    }


    public List<String> getExec() {
        return exec;
    }


    public Set<String> getOutput_files() {
        return output_files;
    }

    public Set<String> getInput_files() {
        return input_files;
    }
}
