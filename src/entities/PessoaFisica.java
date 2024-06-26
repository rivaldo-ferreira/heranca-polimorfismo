package entities;

import java.time.LocalDate;

public class PessoaFisica extends Pessoa{

    private Double gastosComSaude;

    public PessoaFisica(){
        super();
    }

    public PessoaFisica(String nome, Double rendaAnual, LocalDate data, Double gastosComSaude) {
        super(nome, rendaAnual, data);
        this.gastosComSaude = gastosComSaude;
    }

    public Double getGastosComSaude() {
        return gastosComSaude;
    }

    public void setGastosComSaude(Double gastosComSaude) {
        this.gastosComSaude = gastosComSaude;
    }

    public double saude(){
        return gastosComSaude / 2;
    }

    public double calculoPessoaFisica(){
        double valorImposto = 0.0;
        if(super.getRendaAnual() < 20000){
            valorImposto = super.getRendaAnual() * 0.15;
        } else {
            valorImposto = (super.getRendaAnual() * 0.25) - saude();
        }
        return valorImposto;
    }

    public double totalAReceber(){
        return super.getRendaAnual() - calculoPessoaFisica();
    }

    @Override
    public String dadosPessoa(){
        return super.dadosPessoa() + "\n" +
                "Gastos/Saúde: " + String.format("%.2f",gastosComSaude) + " - Abatido no Imposto: R$ " + String.format("%.2f",saude()) +
                "\nTotal de Impostos: R$ " + String.format("%.2f",calculoPessoaFisica()) +
                "\nValor a Receber: R$ " + String.format("%.2f", totalAReceber()) +
                "\n--------------------";
    }
}
