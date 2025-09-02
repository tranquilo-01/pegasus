package edu.isi.pegasus.planner.code.generator.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.isi.pegasus.planner.classes.ADag;
import edu.isi.pegasus.planner.classes.Job;
import edu.isi.pegasus.planner.classes.PegasusFile;
import edu.isi.pegasus.planner.code.CodeGeneratorException;
import edu.isi.pegasus.planner.code.generator.Abstract;
import edu.isi.pegasus.planner.partitioner.graph.GraphNode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JsonGenerator extends Abstract {
    @Override
    public Map<String, String> getAdditionalBraindumpEntries(ADag workflow) {
        return Map.of();
    }

    @Override
    public Collection<File> generateCode(ADag dag) throws CodeGeneratorException {
        List<File> generatedFiles = new ArrayList<>();
        Gson gson = new GsonBuilder().create();

        Set<Node> jsonNodes = convertToNodes(dag);

        String json = gson.toJson(jsonNodes);

        File generatedFile = new File(this.mSubmitFileDir, "json_generator_output.json");
        try (FileWriter writer = new FileWriter(generatedFile)) {
            writer.write(json);
        } catch (IOException e) {
            throw new CodeGeneratorException("Error writing generated file: " + generatedFile.getAbsolutePath(), e);
        }
        generatedFiles.add(generatedFile);
        return generatedFiles;
    }

    private Set<Node> convertToNodes(ADag dag) {
        Set<Node> nodes = new HashSet<>();

        for (Iterator<GraphNode> it = dag.nodeIterator(); it.hasNext(); ) {
            GraphNode graphNode = it.next();
            Job job = (Job) graphNode.getContent();

            Collection<GraphNode> parents = graphNode.getParents();
            ArrayList<String> requirements = new ArrayList<>();
            for (GraphNode parent : parents) {
                requirements.add(parent.getID());
            }

            Set<String> outputFileNames = new HashSet<>();
            Set<String> inputFileNames = new HashSet<>();

            for (Object file : job.outputFiles) {
                String fileName = ((PegasusFile) file).getLFN();
                outputFileNames.add(fileName);
            }

            for (Object file : job.inputFiles) {
                String fileName = ((PegasusFile) file).getLFN();
                inputFileNames.add(fileName);
            }

            String command = job.executable + " " + job.getArguments();

            Node jsonNode = new Node(graphNode.getID(), requirements, new Input(InputType.JOB, job.executable, job.jobID), command, inputFileNames, outputFileNames, job.getDirectory());

            nodes.add(jsonNode);
        }
        return nodes;
    }


    @Override
    public void generateCode(ADag dag, Job job) throws CodeGeneratorException {
        // not used for now
    }
}
