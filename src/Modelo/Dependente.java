package Modelo;

import java.util.Objects;

public class Dependente
{
    private Pessoa p1;
    private Local l1;
    private  Integer id;
    private String nome;

    public Pessoa getP1() {
        return p1;
    }

    public void setP1(Pessoa p1) {
        this.p1 = p1;
    }
    
    

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
    
    public Local getL1()
    {
        return l1;
    }

    public void setL1(Local l1)
    {
        this.l1 = l1;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Dependente other = (Dependente) obj;
        if (!Objects.equals(this.id, other.id))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Dependente{" + "p1=" + p1 + ", l1=" + l1 + ", id=" + id + ", nome=" + nome + '}';
    }
    



}
