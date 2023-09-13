package assign6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class read_write_files {
    
    

    static class CreateFile {
        public static void main(String[] args) {
            try {
                File myObj = new File("filename1.txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    static class WriteString {
        // Main driver method
        public static void main(String[] args)
                throws IOException {
            // Assigning the content of the file
            String text = "This is UCC";
            // Defining the file name of the file
            Path fileName = Path.of("/Users/peter/Desktop/2nd_year/intro_java/filename.txt");
            // Writing into the file
            Files.writeString(fileName, text);
            // Reading the content of the file
            String file_content = Files.readString(fileName);
            // Printing the content inside the file
            System.out.println(file_content);
        }
    }

    static class BufferedWrite {
        // Main driver method
        public static void main(String[] args) {
            // Assigning the file content
            // Note: Custom contents taken as input to
            // illustrate
            String text = "This is UCC";
            // Try block to check for exceptions
            try {
                // Step 1: Create an object of BufferedWriter
                BufferedWriter f_writer = new BufferedWriter(
                        new FileWriter("/Users/peter/Desktop/2nd_year/intro_java/filename.txt"));
                // Step 2: Write text(content) to file
                f_writer.write(text);
                // Step 3: Printing the content inside the file
                // on the terminal/CMD
                System.out.print(text);
                // Step 4: Display message showcasing
                // successful execution of the program
                System.out.print("File is created successfully with the content.");
                // Step 5: Close the BufferedWriter object
                f_writer.close();
            }
            // Catch block to handle if exceptions occurs
            catch (IOException e) {
                // Print the exception on console
                // using getMessage() method
                System.out.print(e.getMessage());
            }
        }
    }

    static class FileOutStream {
        // Main driver method
        public static void main(String[] args) {
            // Assign the file content
            String fileContent = "This is UCC rugby";
            FileOutputStream outputStream = null;
            // Try block to check if exception occurs
            try {
                // Step 1: Create an object of FileOutputStream
                outputStream = new FileOutputStream("file.txt");
                // Step 2: Store byte content from string
                byte[] strToBytes = fileContent.getBytes();
                // Step 3: Write into the file
                outputStream.write(strToBytes);
                // Print the success message (Optional)
                System.out.print(
                        "File is created successfully with the content.");
            }
            // Catch block to handle the exception
            catch (IOException e) {
                // Display the exception/s
                System.out.print(e.getMessage());
            }
            // finally keyword is used with in try catch block
            // and this code will always execute whether
            // exception occurred or not
            finally {
                // Step 4: Close the object
                if (outputStream != null) {
                    // Note: Second try catch block ensures that
                    // the file is closed even if an error
                    // occurs
                    try {
                        // Closing the file connections
                        // if no exception has occurred
                        outputStream.close();
                    } catch (IOException e) {
                        // Display exceptions if occurred
                        System.out.print(e.getMessage());
                    }
                }
            }
        }

        static class WriteToFile {
            public static void main(String[] args) {
                try {
                    FileWriter myWriter = new FileWriter("filename.txt");
                    myWriter.write("This is UCCfdfbfd");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }
    }

    static class BufferRead {
        // main driver method
        public static void main(String[] args) throws Exception {
            // File path is passed as parameter
            File file = new File(
                    "/Users/peter/Desktop/2nd_year/intro_java/filename.txt");
            // Creating an object of BufferedReader class
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Declaring a string variable
            String st;
            // Condition holds true till
            // there is character in a string
            while ((st = br.readLine()) != null)
                // Print the string
                System.out.println(st);
           
        }

        // close the br
        
    }

    static class FileRead {
        // Main driver method
        public static void main(String[] args) throws Exception {
            // Passing the path to the file as a parameter
            FileReader fr = new FileReader(
                    "/Users/peter/Desktop/2nd_year/intro_java/filename.txt");
            // Declaring loop variable
            int i;
            // Holds true till there is nothing to read
            while ((i = fr.read()) != -1)
                // Print all the content of a file
                System.out.print((char) i);
        }
    
    }

    static class ReadFileIntoList {
        public static List<String> readFileInList(String fileName) {
            List<String> lines = Collections.emptyList();
            try {
                lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            } catch (IOException e) {
                // do something
                e.printStackTrace();
            }
            return lines;
        }

        public static void main(String[] args) {
            List l = readFileInList("/Users/peter/Desktop/2nd_year/intro_java/filename.txt");
            Iterator<String> itr = l.iterator();
            while (itr.hasNext())
                System.out.println(itr.next());
        }

    }

    static class ReadTextAsString {
        public static String readFileAsString(String fileName) throws Exception {
            String data = "";
            data = new String(Files.readAllBytes(Paths.get(fileName)));
            return data;
        }

        public static void main(String[] args) throws Exception {
            String data = readFileAsString("/Users/peter/Desktop/2nd_year/intro_java/filename.txt");
            System.out.println(data);
        }

    }

    static class ReadFile {
        public static void main(String[] args) {
            try {
                File myObj = new File("filename.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    static class DeleteFile {
        public static void main(String[] args) {
            File myObj = new File("filename.txt");
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
        }
    }

    public class DeleteFolder {
        public static void main(String[] args) {
            File myObj = new File("C:\\Users\\MyName\\Test");
            if (myObj.delete()) {
                System.out.println("Deleted the folder: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the folder.");
            }
        }
    }
}
