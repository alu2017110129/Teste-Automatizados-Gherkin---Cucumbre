package controller;

import io.cucumber.java.bs.A;
import io.cucumber.java.it.Ma;
import model.Aluno;
import model.Telefone;
import repository.AlunoRepository;
import repository.ChaveExisteException;
import repository.ChaveInexisteException;
import view.AlunoView;
import java.util.List;


public class AlunoController {

    public void createAluno(String nome, long matricula, int ddd, String numero, char tipo) {
        Aluno aluno = new Aluno(nome, matricula);
        aluno.addFone(new Telefone(ddd,numero,tipo, true,null));
        try {
            AlunoRepository.getInstance().insertAluno(aluno);
        } catch (ChaveExisteException e) {
            System.out.println("chave "+aluno.getMatricula()+" já cadastrada\n");
        }
    }
    public void listaAlunos() {
        List<Aluno> lista = AlunoRepository.getInstance().buscaTodos();
        AlunoView.listaAlunos(lista);
    }
}