/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package szinekmappel;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author T
 */
public class SzinekMappel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, String> szinek = feltolt("kodok.txt");
        System.out.println("Tárolt színek mennyiége: " + szinek.size());
    }

    private static Map<String, String> feltolt(String fajlNeve) {
        Map<String, String> result = new TreeMap<>();
        List<String> sorok = null;
        try {
            sorok = Files.readAllLines(Paths.get(fajlNeve), Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.out.println("Hiba: " + e.getMessage());
        }
        
        sorok.remove(sorok.size() - 1);
        
        for (String sor : sorok) {
            String[] darabok = sor.split("\t");
            result.put(darabok[1], darabok[0]);
        }
        
        return result;
    }
    
}
