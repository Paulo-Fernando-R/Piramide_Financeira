package DAO;

import Modelo.Dependente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;

public class DAODependente
{

    public List<Dependente> getLista()
    {
        String sql = "select * from dependente";
        List<Dependente> lista = new ArrayList<>();
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Dependente obj = new Dependente();
                obj.setId(rs.getInt("Id"));
                obj.setNome(rs.getString("Nome"));
                obj.setP1(DAOPessoa.localizar(rs.getInt("PessoaId")));

                obj.setL1(DAOLocal.localizar(rs.getInt("LocalId")));

                lista.add(obj);

            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return lista;
    }

    public boolean salvar(Dependente obj)
    {
        if (obj.getId() == null)
        {
            return incluir(obj);
        } else
        {
            return alterar(obj);
        }
    }

    public boolean incluir(Dependente obj)
    {
        String sql = "insert into dependente (Nome, PessoaId, LocalId) values(?,?,?)";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());

            pst.setInt(2, obj.getP1().getId());
            pst.setInt(3, obj.getL1().getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Dependente incluido com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Dependente não incluido com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean alterar(Dependente obj)
    {
        String sql = "update dependente set Nome = ?,PessoaId = ?, LocalId = ? where Id = ?";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());

            pst.setInt(2, obj.getP1().getId());
            pst.setInt(3, obj.getL1().getId());
            pst.setInt(4, obj.getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Dependente alterado com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Dependente não alterado com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }

    }

    public boolean remover(Dependente obj)
    {
        String sql = "delete from dependente where Id = ?";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Dependente excluido com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Dependente não excluido com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + "Este registro está sendo usado em outra tabela");
            return false;
        }
    }

}
