import src.dao.*;
import src.model.*;

public class Main {
    public static void main(String[] args) {
        // Teste AlunoDAO
        AlunoDAO alunoDAO = new AlunoDAO();
        
        // Criar aluno
        Aluno aluno1 = new Aluno("João Silva", "12345678901", "Premium", "2023-01-01");
        alunoDAO.create(aluno1);
        
        // Listar alunos
        System.out.println("Alunos cadastrados:");
        alunoDAO.readAll().forEach(System.out::println);
        
        // Teste FuncionarioDAO
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        // Criar funcionário
        Funcionario funcionario1 = new Funcionario(0, "Maria Souza", "Instrutor", 300000);
        funcionarioDAO.create(funcionario1);
        
        // Listar funcionários
        System.out.println("\nFuncionários cadastrados:");
        funcionarioDAO.readAll().forEach(System.out::println);
        
        // Teste AulaDAO
        AulaDAO aulaDAO = new AulaDAO();
        
        // Criar aula
        Aula aula1 = new Aula(0, "Yoga", "18:00", 20);
        aulaDAO.create(aula1);
        
        // Listar aulas
        System.out.println("\nAulas cadastradas:");
        aulaDAO.readAll().forEach(System.out::println);
        
        // Teste PagamentoDAO
        PagamentoDAO pagamentoDAO = new PagamentoDAO();
        
        // Criar pagamento
        Pagamento pagamento1 = new Pagamento(0, 1, 15000, "Pago");
        pagamentoDAO.create(pagamento1);
        
        // Listar pagamentos
        System.out.println("\nPagamentos cadastrados:");
        pagamentoDAO.readAll().forEach(System.out::println);
        
        // Teste EquipamentoDAO
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        
        // Criar equipamento
        Equipamento equipamento1 = new Equipamento(0, "Esteira", "Disponível");
        equipamentoDAO.create(equipamento1);
        
        // Listar equipamentos
        System.out.println("\nEquipamentos cadastrados:");
        equipamentoDAO.readAll().forEach(System.out::println);
        
        // Atualizar um registro
        System.out.println("\nAtualizando equipamento...");
        equipamento1.setStatus("Em manutenção");
        equipamentoDAO.update(equipamento1);
        equipamentoDAO.readAll().forEach(System.out::println);
        
        // Deletar um registro
        System.out.println("\nDeletando equipamento...");
        equipamentoDAO.delete(equipamento1.getId());
        equipamentoDAO.readAll().forEach(System.out::println);
    }
}
