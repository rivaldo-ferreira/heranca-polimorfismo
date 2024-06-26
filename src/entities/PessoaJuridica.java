package entities;

import java.time.LocalDate;

public class PessoaJuridica extends Pessoa{

    private Integer numeroFuncionarios;

    public PessoaJuridica(){
        super();
    }

    public PessoaJuridica(String nome, Double rendaAnual, LocalDate data, Integer numeroFuncionarios) {
        super(nome, rendaAnual, data);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }
    public double calculoPessoaJuridica(){
        double valorImposto = 0.0;
        if(numeroFuncionarios > 10){
            valorImposto = super.getRendaAnual() * 0.14;
        } else {
            valorImposto = super.getRendaAnual() * 0.16;
        }
        return valorImposto;
    }

    public double totalAReceber(){
        return super.getRendaAnual() - calculoPessoaJuridica();
    }

    @Override
    public String dadosPessoa(){
        return super.dadosPessoa() + "\n" +
                "Total de Impostos: R$ " + String.format("%.2f",calculoPessoaJuridica()) +
                "\nValor a Receber: R$ " + String.format("%.2f", totalAReceber()) +
                "\n---------------------";
    }
}
