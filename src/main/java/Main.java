import java.util.Scanner;
import static view.AlunoView.*;

public class Main {
    public static void main(String[] args) {

        int opcao = 0;
        long matricula = 0;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("\n\n             ### Sistema de Cadastro de Alunos ###");
            System.out.println("\n                  =========================");
            System.out.println("                  |     1 - Incluir       |");
            System.out.println("                  |     2 - Alterar       |");
            System.out.println("                  |     3 - Excluir       |");
            System.out.println("                  |     4 - Listar        |");
            System.out.println("                  |     5 - Alt.Telefone  |");
            System.out.println("                  |     0 - Sair          |");
            System.out.println("                  =========================\n");

            System.out.print("Digite uma opção : ");
            opcao = entrada.nextInt();
            if (opcao == 2 || opcao == 3){
                System.out.print("Digite a matrícula do Aluno: ");
                matricula = entrada.nextInt();
            }
                switch (opcao) {
                case 1:
                    incluirAluno();
                    break;
                case 2:
                    alterarAluno(matricula);
                    break;
                case 3:
                    excluirAluno(matricula);
                    break;
                case 4:
                    listarAlunos();
                case 5:
//                    alterarTelefone();
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}