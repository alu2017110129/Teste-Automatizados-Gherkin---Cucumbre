package view;

import controller.AlunoController;
import io.cucumber.java.bs.A;
import jdk.nashorn.internal.ir.CatchNode;
import model.Aluno;
import model.Telefone;
import repository.AlunoRepository;
import repository.ChaveExisteException;
import repository.ChaveInexisteException;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoView {

    public static void listaAlunos(Aluno aluno) {
        System.out.println(aluno.getMatricula() + " - " + aluno.getNome() + " - " + aluno.getFones().get(0) + "\n");
    }

    public static void listaAlunos(List<Aluno> lista) {
        for (Aluno al : lista) {
            listaAlunos(al);
        }
    }

    public static void incluirAluno() {

        AlunoController controller = new AlunoController();
        controller.createAluno("Antônio Junior", 123456, 51, "999999999", 'R');
        controller.createAluno("Henrique Oliveira", 23656, 51, "999999999", 'R');
        controller.createAluno("João Luis Facco Silva", 2017110129, 51, "998601789", 'R');
        controller.createAluno("Rafael Ribeiro", 1234567, 51, "999999999", 'R');
        controller.createAluno("Pedro Alves", 987654, 51, "9999988888", 'R');
    }

    public static void listarAlunos() {
        AlunoController controller = new AlunoController();
        controller.listaAlunos();
    }

    public static void alterarAluno(long matricula) {
        String nome = AlunoRepository.getInstance().buscaAlunoMatricula(matricula).getNome();
        List fones = AlunoRepository.getInstance().buscaAlunoMatricula(matricula).getFones();
        Scanner ler = new Scanner(System.in);
        String nrofone;
        System.out.print("Matricula: " + matricula + " - Nova Matricula: ");
        matricula = ler.nextLong();
        ler.nextLine();
        System.out.print("Nome Aluno: " + nome + " - Novo Nome: ");
        nome = ler.nextLine();
        for (int f = 0; f <= fones.size()-1; f++){
            System.out.println("Fone " + f + " = " + fones.get(f) + "Novo Telefone: ");
            nrofone = ler.next();
            Telefone fone = new Telefone(51,nrofone,'R',true,null);
            AlunoRepository.getInstance().buscaAlunoMatricula(matricula).addFone(fone);
        }
        AlunoRepository.getInstance().buscaAlunoMatricula(matricula).setMatricula(matricula);
        AlunoRepository.getInstance().buscaAlunoMatricula(matricula).setNome(nome);

    }

    public static void excluirAluno(long matricula) {
        if (AlunoRepository.getInstance().buscaAlunoMatricula(matricula) != null){
            String opcao1 = "n";
            Scanner entrada1 = new Scanner(System.in);
            System.out.print("Confirma a exclusão do Aluno: " + AlunoRepository.getInstance().buscaAlunoMatricula(matricula).getNome() + " (s/n): ");
            opcao1 = entrada1.nextLine();
            if (opcao1.toUpperCase().equals("S")){
                AlunoRepository.getInstance().deleteAluno(matricula);
            }
        }
        else{
            System.out.println("Matricula não cadastrada!");
        }
    }
}