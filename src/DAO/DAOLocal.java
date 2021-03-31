package DAO;

import Modelo.Local;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;

public class DAOLocal
{

    public List<Local> getLista()
    {
        String sql = "select * from local";
        List<Local> lista = new ArrayList<>();

        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Local obj = new Local();
                obj.setId(rs.getInt("Id"));
                obj.setCidade(rs.getString("Cidade"));
                obj.setEstado(rs.getString("Estado"));
                lista.add(obj);

            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return lista;
    }

    public boolean salvar(Local obj)
    {
        if (obj.getId() == null)
        {
            return incluir(obj);
        } else
        {
            return alterar(obj);
        }
    }

    private boolean incluir(Local obj)
    {
        String sql = "insert into local (Cidade,Estado) values(?,?)";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getCidade());
            pst.setString(2, obj.getEstado());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Local incluido com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Local não incluido com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    private boolean alterar(Local obj)
    {
        String sql = "update local set Cidade = ?, Estado = ? where Id = ?";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getCidade());
            pst.setString(2, obj.getEstado());
            pst.setInt(3, obj.getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Local alterado com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Local não alterado com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean remover(Local obj)
    {
        String sql = "delete from local where Id = ?";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Local excluido com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Local não excluido com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + "Este registro está sendo usado em outra tabela");
            return false;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public static Local localizar(Integer id)
    {
        String sql = "select * from local where Id = ?";
        Local obj = new Local();
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                obj.setId(rs.getInt("Id"));
                obj.setCidade(rs.getString("Cidade"));
                obj.setEstado(rs.getString("Estado"));
                return obj;
            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return null;
    }
}
