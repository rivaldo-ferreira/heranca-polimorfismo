package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner dg = new Scanner(System.in);
        List<Pessoa> lista = new ArrayList<>();
        LocalDate data = LocalDate.now();

        System.out.println("***** Pessoa física ou jurídica *****".toUpperCase());
        System.out.println();

        System.out.print("Número de Cadastros: ");
        int n = dg.nextInt();

        for(int i=1; i<=n; i++){
            System.out.print("Nome: ");
            dg.nextLine();
            String nome = dg.nextLine();
            System.out.print("Renda Anual: R$ ");
            double rendaAnual = dg.nextDouble();
            System.out.print("Pessoa Física ou Jurídica (f/j): ");
            char letra = dg.next().charAt(0);

            if(letra == 'f'){
                System.out.print("Total de gastos com saúde: R$ ");
                double gastosSaude = dg.nextDouble();
                lista.add(new PessoaFisica(nome,rendaAnual,data, gastosSaude));
            } else {
                System.out.print("Número de Funcionários: ");
                int numeroFuncionario = dg.nextInt();
                lista.add(new PessoaJuridica(nome, rendaAnual, data, numeroFuncionario));
            }
            System.out.println("-----------------------");
        }

        System.out.println("*** Relatório Final ***");
        for(Pessoa pessoa: lista){
            System.out.println(pessoa.dadosPessoa());
        }
    }
}
