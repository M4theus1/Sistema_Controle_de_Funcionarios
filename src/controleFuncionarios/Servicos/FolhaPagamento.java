package controleFuncionarios.Servicos;

import controleFuncionarios.Entidades.Funcionario;
import controleFuncionarios.Entidades.FuncMeioPer;
import controleFuncionarios.Entidades.FuncPerIntegral;
import controleFuncionarios.Entidades.TipoContrato;

import java.util.List;

public class FolhaPagamento {

    public double calcularSalario(Funcionario funcionario) {
        double salarioBase = funcionario.getSalario();

        // Ajusta o salário base dependendo do tipo de funcionário
        if (funcionario instanceof FuncMeioPer) {
            salarioBase = calcularSalarioMeioPeriodo((FuncMeioPer) funcionario);
        }

        double descontos = calcularDescontos(funcionario);
        return salarioBase - descontos;
    }

    private double calcularSalarioMeioPeriodo(FuncMeioPer funcionario) {
        // Pode ser ajustado conforme as regras de cálculo para estágio
        return funcionario.getSalario() / 2; // Exemplificando com metade do salário
    }

    private double calcularDescontos(Funcionario funcionario) {
        double inss = funcionario.getSalario() * 0.11;
        double ir = calcularImpostoDeRenda(funcionario.getSalario());
        return inss + ir;
    }

    private double calcularImpostoDeRenda(double salario) {
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

    public void processarFolha(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            double salarioLiquido = calcularSalario(funcionario);
            System.out.println("Funcionário: " + funcionario.getNome() + " | Salário Líquido: R$" + salarioLiquido);
        }
    }
}
