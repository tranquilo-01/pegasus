package edu.isi.pegasus.planner.code.generator.json;

import edu.isi.pegasus.planner.classes.ADag;
import edu.isi.pegasus.planner.classes.Job;
import edu.isi.pegasus.planner.code.CodeGeneratorException;
import edu.isi.pegasus.planner.code.generator.Abstract;

import java.io.File;
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
        return List.of();
    }

    @Override
    public void generateCode(ADag dag, Job job) throws CodeGeneratorException {
// not used for now
    }
}
