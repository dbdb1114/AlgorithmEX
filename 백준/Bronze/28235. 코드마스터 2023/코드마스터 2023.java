import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        String 구호 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if(구호.equals("SONGDO")) System.out.println("HIGHSCHOOL");
        if(구호.equals("CODE")) System.out.println("MASTER");        
        if(구호.equals("2023")) System.out.println("0611");
        if(구호.equals("ALGORITHM")) System.out.println("CONTEST");
    }
}