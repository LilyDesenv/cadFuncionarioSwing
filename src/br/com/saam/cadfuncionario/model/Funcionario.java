package br.com.saam.cadfuncionario.model;

import br.com.saam.cadfuncionario.util.StringUtil;
import java.util.Date;

public class Funcionario {
    
    private Long id;
    
    private String nome;
    
    private Date dtAdmissao;
    
    private double salario;
    
    private boolean status;
    
    public Funcionario(){
    }

    public Funcionario(Long id, String nome, Date dtAdmissao, double salario, boolean status) {
        this.id = id;
        this.nome = nome;
        this.dtAdmissao = dtAdmissao;
        this.salario = salario;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "***** DADOS DO FUNCIONÁRIO ******\nNome: " + this.nome
              +"\nData de Admissão: " + StringUtil.formataData(this.dtAdmissao)
              +"\nSalário: "  + StringUtil.formataMoeda(this.salario)
              +"\nStatus: "  + StringUtil.verificaStatus(this.status)
              +"\n*******************************";
    }
}
