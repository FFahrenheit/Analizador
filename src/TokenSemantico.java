/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ivan_
 */
public class TokenSemantico {
    private String token;
    private int linea;

    public TokenSemantico(String token, int linea) {
        this.token = token;
        this.linea = linea;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }
    
    @Override
    public String toString(){
        return this.token + "\t\t @Line " + this.linea;
    }
    
}
