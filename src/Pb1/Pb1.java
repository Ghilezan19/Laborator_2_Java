package Pb1;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
public class Pb1
{
    public static void main(String[] args) throws IOException
    {
        int i=0;
        String[] judete = new String[42];
        Scanner flux_in = new Scanner(new File("C:\\Users\\ghile\\IdeaProjects\\Laborator 2 Java\\src\\Pb1\\judete.txt"));
        while(flux_in.hasNextLine())
        {
            judete[i++] = flux_in.nextLine();
        }
        Arrays.sort(judete);
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Judet: ");
        String jud = reader.readLine();
        System.out.println(jud);
        for(int j=0; j<judete.length; j++)
        {
            if (judete[j].equals(jud))
            {
                System.out.println("Pozitie: " + j);
            }
        }
    }

}
