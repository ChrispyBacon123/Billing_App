
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CrispyBacon
 */
public class PythonExecuter {
    
    public static void ExecutePython(String program){
        try {
            // Specify the command to run the Python script
            String pythonExecutablePath = "/usr/local/bin/python3";
            String pythonScriptPath = "/Users/CrispyBacon/Desktop/Mumsle App/Python Scripts/"+program+".py";
            String[] command = {pythonExecutablePath, pythonScriptPath};


            // Create the process builder
            ProcessBuilder processBuilder = new ProcessBuilder(command);

            // Redirect standard output and error streams (optional)
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to complete (optional)
            int exitCode = process.waitFor();
            System.out.println("Python script "+program+" executed with exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
}
}
