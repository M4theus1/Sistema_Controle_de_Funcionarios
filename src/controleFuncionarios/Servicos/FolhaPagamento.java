package controleFuncionarios.Servicos;

import controleFuncionarios.Entidades.Funcionario;
import controleFuncionarios.Entidades.FuncMeioPer;
import controleFuncionarios.Entidades.FuncPerIntegral;
import java.util.List;

public class FolhaPagamento {

    /**
     * Calcula o salário líquido de um funcionário.
     * @param funcionario O funcionário para quem o salário será calculado.
     * @return O salário líquido do funcionário após descontos.
     */
    public double calcularSalario(Funcionario funcionario) {
        // Calcula o salário base dependendo do tipo de funcionário
        double salarioBase = funcionario instanceof FuncMeioPer 
            ? calcularSalarioMeioPeriodo((FuncMeioPer) funcionario) 
            : funcionario instanceof FuncPerIntegral 
                ? funcionario.getSalario() 
                : funcionario.getSalario();

        // Calcula os descontos e subtrai do salário base
        double descontos = calcularDescontos(funcionario);
        return salarioBase - descontos;
    }

    /**
     * Calcula o salário para funcionários de meio período.
     * @param funcionario O funcionário de meio período.
     * @return O salário calculado para meio período.
     */
    private double calcularSalarioMeioPeriodo(FuncMeioPer funcionario) {
        // Considera que o salário de meio período é metade do salário total
        return funcionario.getSalario() / 2;
    }

    /**
     * Calcula o total de descontos para o funcionário.
     * @param funcionario O funcionário para quem os descontos serão calculados.
     * @return O total de descontos aplicados ao salário do funcionário.
     */
    private double calcularDescontos(Funcionario funcionario) {
        // Calcula o desconto do INSS como 11% do salário
        double inss = funcionario.getSalario() * 0.11;

        // Calcula o imposto de renda baseado no salário
        double ir = calcularImpostoDeRenda(funcionario.getSalario());

        // Retorna o total de descontos (INSS + imposto de renda)
        return inss + ir;
    }

    /**
     * Calcula o imposto de renda baseado no salário.
     * @param salario O salário do funcionário.
     * @return O valor do imposto de renda a ser descontado.
     */
    private double calcularImpostoDeRenda(double salario) {
        // Aplica as faixas de imposto de renda conforme a tabela
        if (salario <= 1903.98) {
            return 0.0;
        } else if (salario <= 2826.65) {
            return salario * 0.075;
        } else if (salario <= 3751.05) {
            return salario * 0.15;
        } else if (salario <= 4664.68) {
            return salario * 0.225;
        } else {
            return salario * 0.275;
        }
    }

    /**
     * Processa a folha de pagamento para uma lista de funcionários.
     * @param funcionarios A lista de funcionários a ser processada.
     */
    public void processarFolha(List<Funcionario> funcionarios) {
        // Itera sobre todos os funcionários e imprime o salário líquido
        for (Funcionario funcionario : funcionarios) {
            double salarioLiquido = calcularSalario(funcionario);
            System.out.println("Funcionário: " + funcionario.getNome() + " | Salário Líquido: R$" + salarioLiquido);
        }
    }
}
