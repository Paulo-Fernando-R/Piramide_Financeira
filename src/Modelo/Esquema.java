package Modelo;

import java.util.Objects;

public class Esquema
{
    private  Integer id;
    private String nome;
    private Double lucro;
    private Local l1;
    private Marca m1;


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

    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    public Local getL1()
    {
        return l1;
    }

    public void setL1(Local l1)
    {
        this.l1 = l1;
    }

    public Marca getM1()
    {
        return m1;
    }

    public void setM1(Marca m1)
    {
        this.m1 = m1;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Esquema other = (Esquema) obj;
        if (!Objects.equals(this.id, other.id))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return nome;//"Esquema{" + "id=" + id + ", nome=" + nome + ", lucro=" + lucro + ", l1=" + l1 + ", m1=" + m1 + '}';
    }


 
}
