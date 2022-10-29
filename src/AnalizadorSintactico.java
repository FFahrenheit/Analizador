/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Usuario
 */
public class AnalizadorSintactico {
    private String codigo;
    private String[] lineas;
    private ArrayList<TokenSintactico> tokens;
    private int index;
    private ArrayList<String> variables;
    private int warningCount;
    
    public AnalizadorSintactico(String fuente)
    {
        this.codigo = fuente;
        this.lineas = fuente.split("\n");
        System.out.println("" + lineas.length + " a analizar");
        tokens = new ArrayList<>();
    }
    
    public String analyze()
    {
        String warnings = "";
        for(int i = 0; i < lineas.length; i++)
        {
            String linea = lineas[i];
            System.out.println(linea);
            linea = linea.trim();
            
            if(linea.equals(""))
            {
                continue;
            }
            
            String resto = linea;
            do
            {
                String token = getTokenUntil(resto);
                resto = getTokenFrom(resto);
                System.out.println("Token: " + token);
                System.out.println("Resto: " + resto);
                if(!token.equals(""))
                {
                    tokens.add(new TokenSintactico(token, i + 1));
                }
            }while(!resto.equals(""));
            
        }
        this.variables = new ArrayList<>();
        this.warningCount = 0;
        
        for(int j = 0; j < tokens.size(); j++){
            TokenSintactico t = tokens.get(j);
            System.out.println("[" + (j+1) +  "]" + t);
            if(TokenAnalyzer.isDataType(t.getToken())){
                String varName = tokens.get(j+1).getToken();
                if(this.isAlreadyDeclared(varName)){
                    this.error("\"" + varName + "\" ya ha sido declarado", "Error de declaracion");
                }else{
                    this.variables.add(varName);
                }
            }
        }
        
        for (int i = 0; i < variables.size(); i++) {
            int count = 0;
            for (int j = 0; j < tokens.size(); j++) {
                if(variables.get(i).equals(tokens.get(j).getToken())){
                    count += 1;
                }
            }
            if(count < 2){
                this.warningCount += 1;
                warnings += "\nAdvertencia: \"" + variables.get(i) + "\" está declarada pero no es usada";
            }
        }
        
        return warnings;
    }
    
    public int getWarningCount(){
        return this.warningCount;
    }
    
    private boolean isAlreadyDeclared(String token){
        return this.variables.contains(token);
    }
    
    public String getTokenUntil(String input)
    {
        String out = "";
        for(int i = 0; i < input.length(); i++)
        {
            String token = "" + input.charAt(i);
            token = token.trim();
            
            if(token.equals(""))
            {
                return out;
            }
            if(TokenAnalyzer.isOperator(token))
            {
                String next = "" + input.charAt(i + 1);
                if(next.equals("=") && (token.equals("=") || token.equals("<") || token.equals(">") || token.equals("!")))
                {
                    return out.equals("") ? token + next : out;
                }
            }
            if(TokenAnalyzer.isGrouping(token) || TokenAnalyzer.isEnd(token))
            {
                return out.equals("") ? token : out;
            }
            out += token;
        }
        return out;
    }
    
    public String getTokenFrom(String input)
    {
        
        for(int i = 0; i < input.length(); i++)
        {
            String token = "" + input.charAt(i);
            token = token.trim();
            System.out.println("t: " + token);
            if(token.equals(""))
            {
                return input.substring(i).trim();
            }
            if(TokenAnalyzer.isOperator(token))
            {
                String next = "" + input.charAt(i + 1);
                if(next.equals("=") && (token.equals("=") || token.equals("<") || token.equals(">") || token.equals("!")))
                {
                    System.out.println("Mayor");
                    System.out.println(input);
                    System.out.println(i);
                    return i == 0 ? input.substring(i + 2).trim() : input.substring(i).trim();
                }
            }
            if(TokenAnalyzer.isGrouping(token) || TokenAnalyzer.isEnd(token))
            {
                return i == 0 ? input.substring(i + 1).trim() : input.substring(i).trim();
            }
        }
        return "";
    }
    
    private void error(String description, String title){
        JOptionPane.showMessageDialog(null,
                    description,
                    title,
                    JOptionPane.ERROR_MESSAGE);
    }
}
