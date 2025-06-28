package edu.isi.pegasus.planner.code.generator.text;

import edu.isi.pegasus.planner.classes.ADag;
import edu.isi.pegasus.planner.classes.Job;
import edu.isi.pegasus.planner.classes.PegasusBag;
import edu.isi.pegasus.planner.code.CodeGeneratorException;
import edu.isi.pegasus.planner.code.generator.Abstract;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class TextGenerator extends Abstract {


    @Override
    public void initialize(PegasusBag bag) throws CodeGeneratorException {
        super.initialize(bag);
    }

    @Override
    public Collection<File> generateCode(ADag dag) throws CodeGeneratorException {
        List<File> generatedFiles = new ArrayList<>();

        File generatedFile = new File(this.mSubmitFileDir, "text_generator_output.txt");
        try (FileWriter writer = new FileWriter(generatedFile)) {
            writer.write(dag.toString());
        } catch (IOException e) {
            throw new CodeGeneratorException("Error writing generated file: " + generatedFile.getAbsolutePath(), e);
        }
        generatedFiles.add(generatedFile);
        return generatedFiles;
    }

    @Override
    public void generateCode(ADag dag, Job job) throws CodeGeneratorException {
        // This method is not required for the simple text generator
    }


    @Override
    public Map<String, String> getAdditionalBraindumpEntries(ADag workflow) {
        return Map.of();
    }

    @Override
    public void reset() throws CodeGeneratorException {
        // Reset any internal state, if necessary
    }
}