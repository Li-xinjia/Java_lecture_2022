import java.io.*;
import java.util.Vector;

public class BookModel {
    void writeLine(String line) {
        try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter("book.txt", true));) {
            buffWriter.write(line);
            buffWriter.newLine();
        } catch (IOException e) {
            System.out.println("Write Error");
        }
    }

    Vector<String> readLine() {
        String readData;
        Vector<String> lines = new Vector<>();
        try (BufferedReader buffReader = new BufferedReader(new FileReader("book.txt"));) {
            readData = buffReader.readLine();
            lines.add(readData);
            while (readData != null) {
                readData = buffReader.readLine();
                lines.add(readData);
            }
            buffReader.close();
            return lines;
        } catch (IOException e) {
            System.out.println("Read Error");
            return null;
        }
    }

}
