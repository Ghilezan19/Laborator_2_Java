package Pb4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class Persoana
{
    private String nume;
    private String cnp;
    public Persoana(String nume, String cnp)
    {
        this.nume = nume;
        this.cnp = cnp;
    }
    public String getNume()
    {
        return nume;
    }
    public String getCnp()
    {
        return cnp;
    }
    public int getVarsta()
    {
        int anul, luna, ziua;
        if (cnp.charAt(0) == '1' || cnp.charAt(0) == '2')
        {
            anul = 1900 + Integer.parseInt(cnp.substring(1, 3));
        } else
        {
            anul = 2000 + Integer.parseInt(cnp.substring(1, 3));
        }
        luna = Integer.parseInt(cnp.substring(3, 5));
        ziua = Integer.parseInt(cnp.substring(5, 7));
        LocalDate dataNasterii = LocalDate.of(anul, luna, ziua);
        LocalDate dataCurenta = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(dataNasterii, dataCurenta);
    }
}
public class Pb4
{
    static String readCnp(BufferedReader reader) throws IOException
    {
        String cnp;
        boolean valid = false;
        while (!valid)
        {
            System.out.print("Introduceti CNP: ");
            cnp = reader.readLine();
            if (cnp.length() != 13)
            {
                System.out.println("CNP invalid: lungimea trebuie să fie 13 caractere. Reintroduceti CNP-ul.");
                continue;
            }
            if (!cnp.matches("\\d+"))
            {
                System.out.println("CNP invalid: toate caracterele trebuie sa fie cifre. Reintroduceti CNP-ul.");
                continue;
            }
            if (cnp.charAt(0) != '1' && cnp.charAt(0) != '2' && cnp.charAt(0) != '5' && cnp.charAt(0) != '6')
            {
                System.out.println("CNP invalid: prima cifra trebuie sa fie 1, 2, 5 sau 6. Reintroduceti CNP-ul.");
                continue;
            }
            String luna = cnp.substring(3, 5);
            if (Integer.parseInt(luna) < 1 || Integer.parseInt(luna) > 12)
            {
                System.out.println("CNP invalid: luna trebuie sa fie intre 01 și 12. Reintroduceti CNP-ul.");
                continue;
            }
            valid = true;
            return cnp;
        }
        return null;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduceti numarul de persoane: ");
        int n = Integer.parseInt(reader.readLine());
        List<Persoana> persoane = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            System.out.print("Introduceti numele persoanei " + (i + 1) + ": ");
            String nume = reader.readLine();
            String cnp = readCnp(reader);
            persoane.add(new Persoana(nume, cnp));
        }
        System.out.println("\nInformatii persoane:");
        for (Persoana persoana : persoane)
        {
            System.out.println("Nume: " + persoana.getNume() + ", CNP: " + persoana.getCnp() + ", Varsta: " + persoana.getVarsta());
        }
    }
}
