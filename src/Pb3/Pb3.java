package Pb3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Pb3
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduceti sirul de caractere: ");
        StringBuilder str = new StringBuilder(reader.readLine());
        System.out.println("Intoduceti sirul de inserat: ");
        String str1 = reader.readLine();
        System.out.println("La pozitia: ");
        int poz = Integer.parseInt(reader.readLine());

        str.insert(poz, str1);
        System.out.println("Rezultat: ");
        System.out.println(str);

        System.out.println("Introduceti numarul de caractere de sters: ");
        int nrCrt = Integer.parseInt(reader.readLine());

        System.out.println("De la pozitia: ");
        int start = Integer.parseInt(reader.readLine());
        int end = nrCrt + start;

        str.delete(start, end);
        System.out.println("Rezultat: ");
        System.out.println(str);
    }

}
