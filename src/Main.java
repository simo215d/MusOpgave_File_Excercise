import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.io.IOException{
        File file = new File("MusLog.txt");
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        output.println("Mus spil med pebbernødder");

        int randomNumber = (int)(Math.random()*5+5);
        System.out.println("Der er "+randomNumber+" pebbernødder");
        int[] pebberNuts = new int[randomNumber];
        Arrays.fill(pebberNuts,1);
        pebberNuts[(int)(Math.random()*pebberNuts.length)]=0;
        Scanner input = new Scanner(System.in);
        while (true){
            int countsOf1 = 0;
            int number = input.nextInt();
            output.println("The user entered: "+number);
            if (pebberNuts[number]==0){
                System.out.println("Muuus");
                pebberNuts[number]=-1;
                //find ny mus
                while (true){
                    for (int i = 0; i < pebberNuts.length; i++) {
                        if (pebberNuts[i]==1){
                            countsOf1++;
                        }
                    }
                    if (countsOf1==0){
                        System.out.println("There are no more pebbernuts");
                        break;
                    }
                    int n = (int)(Math.random()*pebberNuts.length);
                    if (pebberNuts[n]==1){
                        pebberNuts[n]=0;
                        break;
                    }
                }
                if (countsOf1==0){
                    System.out.println("Game Over");
                    output.println("Game Over");
                    break;
                }
            } else if (pebberNuts[number]==1){
                System.out.println("Du fik en pebbernød");
                pebberNuts[number]=-1;
            } else if (pebberNuts[number]==-1)
            System.out.println("Denne pebbenød er allerede taget.");
        }
        output.close();
    }
}