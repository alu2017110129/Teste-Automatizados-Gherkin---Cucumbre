package model;

public class Telefone {
    private int ddd;
    private String numero;
    private char tipo;
    private boolean preferencial;
    private String contato;

    public Telefone(int ddd, String numero, char tipo, boolean preferencial, String contato) {
        this.ddd = ddd;
        this.numero = numero;
        this.tipo = tipo;
        this.preferencial = preferencial;
        this.contato = contato;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "("+ddd+") "+numero+ " "+tipo;
    }
}
