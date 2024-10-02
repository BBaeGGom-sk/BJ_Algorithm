import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int Num = 0;
        for(int i = 3; i > 0; i--) {
            String temp = br.readLine();
            if(!temp.equals("Fizz") && !temp.equals("Buzz") && !temp.equals("FizzBuzz")) {
                Num = Integer.parseInt(temp)+i;
                break;
            }
        }

        if(Num%3 == 0) {
            if(Num%5 == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println("Fizz");
            }
        } else if(Num%5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(Num);
        }
    }
}