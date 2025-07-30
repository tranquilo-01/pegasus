package edu.isi.pegasus.planner.code.generator.json;
import com.google.gson.annotations.SerializedName;


public enum InputType {
    @SerializedName("file")
    FILE("file"),

    @SerializedName("job")
    JOB("job");

    private final String typeName;

    InputType(String typeName) {
        this.typeName = typeName;
    }
}
