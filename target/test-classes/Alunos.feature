Feature: Cadastro de Alunos
  Scenario: Incluir Aluno
    Given o app iniciou
    And escolhido menu de Incluir
    And foi criado o Controller
    Then gravado aluno no repository

   Scenario: Alterar Aluno
     Given o app iniciou
     And escolhido menu Alterar
     And informado numero da matricula
     And lido os dados do repository
     Then gravado aluno no repository

    Scenario: Excluir Aluno
      Given o app iniciou
      And escolhido o menu excluir
      And busca nome no repository
      And gravado aluno no repository

    Scenario: Listar Aluno
      Given o app iniciou
      And escolhido o menu listar
      And foi criado o Controller
      Then lista controller alunos