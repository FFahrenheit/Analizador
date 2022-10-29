/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;


/**
 *
 * @author Usuario
 */
public class AnalizadorSemantico {
    private String[] lineas;
    private ArrayList<TokenSemantico> tokens;
    private HashMap<String, Integer> variables;
    private int warningCount;
    private String warnings;
    
    public AnalizadorSemantico(String fuente)
    {
        this.lineas = fuente.split("\n");
        System.out.println("" + lineas.length + " a analizar");
        tokens = new ArrayList<>();
    }
    
    public String analyze()
    {
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
                    tokens.add(new TokenSemantico(token, i + 1));
                }
            }while(!resto.equals(""));
            
        }
        this.variables = new HashMap<>();
        
        for(int j = 0; j < tokens.size(); j++){
            TokenSemantico t = tokens.get(j);
            System.out.println("[" + (j+1) +  "]" + t);
            
            if(TokenAnalyzer.isDataType(t.getToken())){
                String varName = tokens.get(j+1).getToken();
                
                if(this.variables.containsKey(varName)){
                    this.error("\"" + varName + "\" ya ha sido declarado", "Error de declaracion");
                }else{
                    this.variables.put(varName, 0);
                }
                
                j++; //Skip varName token
            }else if(TokenAnalyzer.isIdentifier(t.getToken()) && this.variables.containsKey(t.getToken())){
                this.variables.put(t.getToken(), this.variables.get(t.getToken())+1);
            }
        }
        
        this.warnings = "";
        this.warningCount = 0;
        
        this.variables.forEach((varName, count) -> {
            if(count < 2){
                this.warningCount += 1;
                this.warnings += "\nAdvertencia: \"" + varName + "\" está declarada pero no es usada";
            }
        });
        
        return this.warnings;
    }
    
    public int getWarningCount(){
        return this.warningCount;
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
