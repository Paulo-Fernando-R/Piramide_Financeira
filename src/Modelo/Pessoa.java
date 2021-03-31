package Modelo;

import java.util.Objects;

public class Pessoa
{
    private Integer id;
    private String nome;
    private Integer nivel;
    private Double ganho;
    private String cpf;
    private Pessoa cara_acima;
    private Local l1;
    private Esquema e1;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Double getGanho() {
        return ganho;
    }

    public void setGanho(Double ganho) {
        this.ganho = ganho;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa getCara_acima() {
        return cara_acima;
    }

    public void setCara_acima(Pessoa cara_acima) {
        this.cara_acima = cara_acima;
    }

    public Local getL1()
    {
        return l1;
    }

    public void setL1(Local l1)
    {
        this.l1 = l1;
    }

    public Esquema getE1()
    {
        return e1;
    }

    public void setE1(Esquema e1)
    {
        this.e1 = e1;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return nome;//"Pessoa{" + "id=" + id + ", nome=" + nome + ", nivel=" + nivel + ", ganho=" + ganho + ", cpf=" + cpf + ", cara_acima=" + cara_acima + ", l1=" + l1 + ", e1=" + e1 + '}';
    }



}
