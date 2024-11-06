/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comparingarticles;

import java.io.*;
import java.util.*;

/**
 *
 * @author jayia
 */
public class ComparingArticles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

//        set to read article: Java.txt
        Set<String> Java = new HashSet<>();
        String line = "";

        try (BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\jayia\\OneDrive - Humber College\\Documents\\NetBeansProjects\\ComparingArticles\\src\\comparingarticles\\Java.txt"))) {
            while ((line = r.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " .'\"-,:;()[]{}`/*+");

                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    Java.add(token);
                }
            }

        }

//        set to read article: JavaCPP.txt
        Set<String> JavaCPP = new HashSet<>();
        line = "";

        try (BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\jayia\\OneDrive - Humber College\\Documents\\NetBeansProjects\\ComparingArticles\\src\\comparingarticles\\JavaCPP.txt"))) {
            while ((line = r.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " .'\"-,:;()[]{}`/*+");

                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    JavaCPP.add(token);
                }
            }
        }

//        set to read article: NHL.txt
        Set<String> NHL = new HashSet<>();
        line = "";

        try (BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\jayia\\OneDrive - Humber College\\Documents\\NetBeansProjects\\ComparingArticles\\src\\comparingarticles\\NHL.txt"))) {
            while ((line = r.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " .'\"-,:;()[]{}`/*+");

                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    NHL.add(token);
                }
            }
        }

//         compare the sets

        //Java and JavaCPP
        Set<String> Java_JavaCPP = new HashSet<>(Java);
        Java_JavaCPP.retainAll(JavaCPP); //intersection

        Set<String> Java_u_JavaCPP = new HashSet<>(Java);
        Java_u_JavaCPP.addAll(JavaCPP); //union

        float sim = (float) Java_JavaCPP.size() / Java_u_JavaCPP.size();


        //Java and NHL
        Set<String> Java_NHL = new HashSet<>(Java);
        Java_NHL.retainAll(NHL); //intersection

        Set<String> Java_u_NHL = new HashSet<>(Java);
        Java_u_NHL.addAll(NHL); //union

        float sim2 = (float) Java_NHL.size() / Java_u_NHL.size();

        
         //JavaCPP and NHL
        Set<String> JavaCPP_NHL = new HashSet<>(JavaCPP);
        JavaCPP_NHL.retainAll(NHL); //intersection

        Set<String> JavaCPP_u_NHL = new HashSet<>(JavaCPP);
        JavaCPP_u_NHL.addAll(NHL); //union

        float sim3 = (float) JavaCPP_NHL.size() / JavaCPP_u_NHL.size();
        
//        results
        System.out.println("---------");
        System.out.println("Number of similar words");
        System.out.println("Java.txt and JavaCPP.txt: "+ Java_JavaCPP.size() + " words");        
        System.out.println("Java.txt and NHL.txt: "+ Java_NHL.size() + " words");
        System.out.println("NHL.txt and JavaCPP.txt: "+ JavaCPP_NHL.size() + " words");
        
        System.out.println("----------");
        System.out.println("Similarity Scores ");
        System.out.println("Java.txt and JavaCPP.txt: " + sim);
        System.out.println("Java.txt and NHL.txt: " + sim2);
        System.out.println("NHL.txt and JavaCPP.txt: " + sim3);
        
        


    }

}
