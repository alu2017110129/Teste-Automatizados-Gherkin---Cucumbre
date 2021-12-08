import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import controller.AlunoController;
import io.cucumber.gherkin.Main;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import io.cucumber.plugin.event.TestRunStarted;
import io.cucumber.plugin.event.TestStepStarted;
import javafx.scene.effect.ImageInput;
import model.Aluno;
import repository.AlunoRepository;

import java.util.List;

import static view.AlunoView.*;

public class AlunosSteps {
    @io.cucumber.java.en.Given("^o app iniciou$")
    public void oAppIniciou() {

    }

    @io.cucumber.java.en.And("^foi criado o Controller$")
    public void foiCriadoOController() {
        AlunoController controller = new AlunoController();
        if (controller == null) {
            throw new AssertionError();
        }
    }

    @And("escolhido menu de Incluir")
    public void escolhidoMenuDeIncluir() {
        incluirAluno();
    }

    @Then("gravado aluno no repository")
    public void gravadoAlunoNoRepository() {
        AlunoController controller = new AlunoController();
        controller.createAluno("Antônio Junior", 123456, 51, "999999999", 'R');
        String nome = AlunoRepository.getInstance().buscaAlunoMatricula(123456).getNome();
        if (nome != "Antônio Junior") {
            throw new AssertionError();
        }
    }

    @And("escolhido menu Alterar")
    public void escolhidoMenuAlterar() {
        //AlunoController controller = new AlunoController();
        //controller.createAluno("Antônio Junior", 123456, 51, "999999999", 'R');
        //alterarAluno(123456);
    }

    @And("informado numero da matricula")
    public void informadoNumeroDaMatricula() {
        //matricula = "123456";
    }

    @And("lido os dados do repository")
    public void lidoOsDadosDoRepository() {
        AlunoController controller = new AlunoController();
        controller.createAluno("Antônio Junior", 123456, 51, "999999999", 'R');
        String nome = AlunoRepository.getInstance().buscaAlunoMatricula(123456).getNome();
        List fones = AlunoRepository.getInstance().buscaAlunoMatricula(123456).getFones();
        if (nome != "Antônio Junior" && fones.get(0) != "(51) 999999999 R" ){
            throw new AssertionError();
        }
    }

    @And("escolhido o menu excluir")
    public void escolhidoOMenuExcluir() {
        //excluirAluno(123456);
    }

    @And("busca nome no repository")
    public void buscaNomeNoRepository() {
        AlunoController controller = new AlunoController();
        controller.createAluno("Antônio Junior", 123456, 51, "999999999", 'R');
        String nome = AlunoRepository.getInstance().buscaAlunoMatricula(123456).getNome();
        System.out.println(nome);

        if (nome != "Antônio Junior") {
            throw new AssertionError();
        }
    }

    @And("escolhido o menu listar")
    public void escolhidoOMenuListar() {
        //listaAlunos(lista);
    }

    @Then("lista controller alunos")
    public void listaControllerAlunos() {
        AlunoController controller = new AlunoController();
        controller.createAluno("Antônio Junior", 123456, 51, "999999999", 'R');
        controller.createAluno("Henrique Oliveira", 23656, 51, "999999999", 'R');
        controller.createAluno("João Luis Facco Silva", 2017110129, 51, "998601789", 'R');
        controller.createAluno("Rafael Ribeiro", 1234567, 51, "999999999", 'R');
        controller.createAluno("Pedro Alves", 987654, 51, "9999988888", 'R');
        List<Aluno> lista = AlunoRepository.getInstance().buscaTodos();
        if(lista.size()!=5) {
            throw new AssertionError();
        }
    }
}