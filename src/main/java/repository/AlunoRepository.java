package repository;

import model.Aluno;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlunoRepository {
    private static Map<Long, Aluno> dados;
    private static AlunoRepository instance;

    public AlunoRepository() {
        dados = new HashMap<Long, Aluno>();
    }

    public static AlunoRepository getInstance() {
        if (instance == null) {
            instance = new AlunoRepository();
        }
        return instance;
    }

    public void insertAluno(Aluno aluno) throws ChaveExisteException {
        if (!dados.containsKey(aluno.getMatricula())) {
            dados.put(aluno.getMatricula(), aluno);
        } else {
            throw new ChaveExisteException();
        }
    }

    public void updateAluno(Aluno aluno) throws ChaveInexisteException {
        if (dados.containsKey(aluno.getMatricula())) {
            dados.put(aluno.getMatricula(), aluno);
        } else {
            throw new ChaveInexisteException();
        }
    }

    public Aluno buscaAlunoMatricula(long matr) {
        return dados.get(matr);
    }

    public List<Aluno> buscaTodos() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        alunos.addAll(dados.values());
        return alunos;
    }

    public Aluno deleteAluno(long matr) {
        return dados.remove(matr);
    }
}