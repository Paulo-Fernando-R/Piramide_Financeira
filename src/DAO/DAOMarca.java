package DAO;

import Modelo.Marca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;

public class DAOMarca
{

    public List<Marca> getLista()
    {
        String sql = "select * from marca";
        List<Marca> lista = new ArrayList<>();

        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Marca obj = new Marca();
                obj.setId(rs.getInt("Id"));
                obj.setNome(rs.getString("Nome"));
                obj.setTipo(rs.getString("Tipo"));
                lista.add(obj);

            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return lista;
    }

    public boolean salvar(Marca obj)
    {
        if (obj.getId() == null)
        {
            return incluir(obj);
        } else
        {
            return alterar(obj);
        }
    }

    private boolean incluir(Marca obj)
    {
        String sql = "insert into marca (Nome, Tipo) values(?,?)";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getTipo());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Marca incluida com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Marca não incluida com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    private boolean alterar(Marca obj)
    {
        String sql = "update marca set Nome = ?, Tipo = ? where Id = ?";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getTipo());
            pst.setInt(3, obj.getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Marca alterada com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Marca não alterada com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean remover(Marca obj)
    {
        String sql = "delete from marca where Id = ?";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Marca excluida com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Marca não excluida com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + "Este registro está sendo usado em outra tabela");
            return false;
        }
    }

    public static Marca localizar(Integer id)
    {
        String sql = "select * from marca where Id = ?";
        Marca obj = new Marca();
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                obj.setId(rs.getInt("Id"));
                obj.setNome(rs.getString("Nome"));
                obj.setTipo(rs.getString("Tipo"));
                return obj;
            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return null;
    }

}
