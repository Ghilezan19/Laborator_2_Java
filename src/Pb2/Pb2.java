package Pb2;
import java.io.*;
import java.util.Random;
class Vers
{
    private String text;
    public Vers(String text)
    {
        this.text = text;
    }
    public int numarCuvinte()
    {
        if (text.isEmpty())
        {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }
    public int numarVocale()
    {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray())
        {
            if ("aeiouăîâ".indexOf(c) != -1)
            {
                count++;
            }
        }
        return count;
    }
    public boolean SeIncheie(String grupare)
    {
        return text.trim().endsWith(grupare);
    }
    public String getText()
    {
        return text;
    }
}
public class Pb2
{
    public static void main(String[] args)
    {
        String inputFilePath = "C:\\Users\\ghile\\IdeaProjects\\Laborator 2 Java\\src\\Pb2\\cantec_in.txt";
        String outputFilePath = "C:\\Users\\ghile\\IdeaProjects\\Laborator 2 Java\\src\\Pb2\\cantec_out.txt";
        Random random = new Random();
        String group = "abc";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                Vers vers = new Vers(line);
                int numarCuvinte = vers.numarCuvinte();
                int numarVocale = vers.numarVocale();
                String outputLine = line + " | " + numarCuvinte + " cuvinte | " + numarVocale + " vocale";
                if (vers.SeIncheie(group))
                {
                    outputLine += " *";
                }
                double randomNumber = random.nextDouble();
                if (randomNumber < 0.1)
                {
                    outputLine = outputLine.toUpperCase();
                }
                bw.write(outputLine);
                bw.newLine();
            }
        } catch (IOException e)
        {
            System.err.println("Eroare la citirea/scrierea fisierelor: " + e.getMessage());
        }
    }
}
