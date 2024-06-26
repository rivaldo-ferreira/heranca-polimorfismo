package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    private String nome;
    private Double rendaAnual;
    private LocalDate data;

    public Pessoa(){

    }

    public Pessoa(String nome, Double rendaAnual, LocalDate data) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String dadosPessoa(){
        return "Data da declaração: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                nome + " - Renda Anual: R$ " + String.format("%.2f",rendaAnual);
    }
}
