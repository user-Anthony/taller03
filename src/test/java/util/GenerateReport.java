package util;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateReport {

    public static void main(String[] args) {

        // donde esta el json
        String jsonFilePath = new File("").getAbsolutePath() + "/target/";
        // donde se va generar el report
        File reportFolder = new File(jsonFilePath + "Reporte");

        Configuration configuration = new Configuration(reportFolder, "JB Movile");
        configuration.setBuildNumber("0001");
        configuration.addClassifications("SO", "Android");
        configuration.addClassifications("Branch", "develop");
        configuration.addClassifications("Suite", "@WhenDo");
        configuration.addClassifications("owner", "JB");

        List<String> jsons = new ArrayList<>();
        jsons.add(jsonFilePath + "cucumber-report.json");

        ReportBuilder reportBuilder = new ReportBuilder(jsons, configuration);
        reportBuilder.generateReports();

    }
}
