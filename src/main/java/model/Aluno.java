package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private long matricula;
    private List<Telefone> fones;

    public Aluno(String nome, long matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.fones = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public List<Telefone> getFones() {
        List<Telefone> tels = new ArrayList();
        tels.addAll(fones);
        return tels;
    }
    public void addFone(Telefone tel) {
        fones.add(tel);
    }
}
