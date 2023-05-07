
package com.mycompany.ado2crud;


public class Computador {

    private int id;
    private String marca = "Fernando Nunes";
    private String hd;
    private String processador;

    public Computador() {
    }

    public Computador(String marca, int id, String hd, String processador) {
        this.marca = marca;
        this.id = id;
        this.hd = hd;
        this.processador = processador;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca(String string) {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public Object getMarca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
