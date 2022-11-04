import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Persist {
    public static void main(String args[]) {
        String buff;

        try (BufferedReader buffKeyboard = new BufferedReader(new InputStreamReader(System.in));) {
            do {
                System.out.print("No:");
                buff = buffKeyboard.readLine();

                if (buff.equals("q")) break;

                System.out.print("Name:");
                buff = buff + " " + buffKeyboard.readLine();

                try(BufferedWriter buffWriter = new BufferedWriter(new FileWriter("student.txt",true));){
                    buffWriter.write(buff);
                    buffWriter.newLine();
                }
                catch(IOException e){
                    System.out.println("Write Error");
                }

            } while (true);
        } catch (IOException e) {
            System.out.println("Ketboard Input Error");
        }
    }
}

