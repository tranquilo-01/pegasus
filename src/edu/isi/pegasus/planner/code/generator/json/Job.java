package edu.isi.pegasus.planner.code.generator.json;

public class Job {

    private final int id;
    private final int[] requirements;
    private final Input input;
    private final String command;
    private final String output_file;

    public Job(int id, int[] requirements, Input input, String command, String output_file) {
        this.id = id;
        this.requirements = requirements;
        this.input = input;
        this.command = command;
        this.output_file = output_file;
    }

    public int getId() {
        return id;
    }

    public int[] getRequirements() {
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
