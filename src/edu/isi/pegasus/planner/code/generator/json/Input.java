package edu.isi.pegasus.planner.code.generator.json;


public class Input {

    private final InputType type;
    private final String path;
    private final int[] jobs_id;

    public Input(InputType type, String path, int[] jobs_id){
        this.type = type;
        this.path = path;
        this.jobs_id = jobs_id;
    }

    public InputType getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public int[] getJobs_id() {
        return jobs_id;
    }


}
