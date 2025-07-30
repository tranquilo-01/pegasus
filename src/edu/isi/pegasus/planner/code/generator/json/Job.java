package edu.isi.pegasus.planner.code.generator.json;

public record Job(int id, int[] requirements, Input input, String command, String output_file) {
}
