/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author ivan_
 */
public class Principal {
    private static String path = System.getProperty("user.dir");
    
    public static void main(String[] args) throws Exception {
        System.out.println(path);
        
        String ruta1 = path + "/src/codigo/Lexer.flex";
        String ruta2 = path + "/src/codigo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", path + "/src/codigo/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    
    public static void generarSintaxis() throws Exception{
                System.out.println(path);
        
        String ruta1 = path + "/src/codigo/Lexer.flex";
        String ruta2 = path + "/src/codigo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", path + "/src/codigo/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get(path + "/src/codigo/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(path + "/sym.java"), 
                Paths.get(path + "/src/codigo/sym.java")
        );
        Path rutaSin = Paths.get(path + "/src/codigo/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(path + "/Sintax.java"), 
                Paths.get(path + "/src/codigo/Sintax.java")
        );
    }
}
