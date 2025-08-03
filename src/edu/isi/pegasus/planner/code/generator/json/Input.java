package edu.isi.pegasus.planner.code.generator.json;


public class Input {

    private final InputType type;
    private final String path;
    private final String job_id;

    public Input(InputType type, String path, String job_id){
        this.type = type;
        this.path = path;
        this.job_id = job_id;
    }

    public InputType getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public String getJobs_id() {
        return job_id;
    }


}
