package edu.isi.pegasus.planner.code.generator.json;

import com.google.gson.Gson;
import edu.isi.pegasus.planner.classes.ADag;
import edu.isi.pegasus.planner.classes.Job;
import edu.isi.pegasus.planner.code.CodeGeneratorException;
import edu.isi.pegasus.planner.code.generator.Abstract;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class JsonGenerator extends Abstract {
    @Override
    public Map<String, String> getAdditionalBraindumpEntries(ADag workflow) {
        return Map.of();
    }

    @Override
    public Collection<File> generateCode(ADag dag) throws CodeGeneratorException {
        List<File> generatedFiles = new ArrayList<>();
        Gson gson = new Gson();
        String json = gson.toJson(dag.getRoots());

        File generatedFile = new File(this.mSubmitFileDir, "json_generator_output.txt");
        try (FileWriter writer = new FileWriter(generatedFile)) {
            writer.write(json);
        } catch (IOException e) {
            throw new CodeGeneratorException("Error writing generated file: " + generatedFile.getAbsolutePath(), e);
        }
        generatedFiles.add(generatedFile);
        return generatedFiles;
    }

    @Override
    public void generateCode(ADag dag, Job job) throws CodeGeneratorException {
// not used for now
    }
}
