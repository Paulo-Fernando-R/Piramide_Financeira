package DAO;

import Modelo.Esquema;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;

public class DAOEsquema
{

    public List<Esquema> getLista()
    {
        String sql = "select * from esquema";
        List<Esquema> lista = new ArrayList<>();
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Esquema obj = new Esquema();
                obj.setId(rs.getInt("Id"));
                obj.setNome(rs.getString("Nome"));

                obj.setLucro(rs.getDouble("Lucro"));

                obj.setL1(DAOLocal.localizar(rs.getInt("LocalId")));

                obj.setM1(DAOMarca.localizar(rs.getInt("MarcaId")));

                lista.add(obj);

            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return lista;
    }

    public boolean salvar(Esquema obj)
    {
        if (obj.getId() == null)
        {
            return incluir(obj);
        } else
        {
            return alterar(obj);
        }
    }

    public boolean incluir(Esquema obj)
    {
        String sql = "insert into esquema (Nome, Lucro, LocalId, MarcaId) values(?,?,?,?)";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setDouble(2, obj.getLucro());
            pst.setInt(3, obj.getL1().getId());
            pst.setInt(4, obj.getM1().getId());

            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Esquema incluido com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Esquema não incluido com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean alterar(Esquema obj)
    {
        String sql = "update esquema set Nome = ?, Lucro = ?,LocalId = ?, MarcaId = ? where Id = ?";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setDouble(2, obj.getLucro());
            pst.setInt(3, obj.getL1().getId());
            pst.setInt(4, obj.getM1().getId());
            pst.setInt(5, obj.getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Esquema alterado com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Esquema não alterado com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }

    }

    public boolean remover(Esquema obj)
    {
        String sql = "delete from esquema where Id = ?";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Esquema excluido com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Esquema não excluido com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + "Este registro está sendo usado em outra tabela");
            return false;
        }
    }

    public static Esquema localizar(Integer id)
    {
        String sql = "select * from esquema where Id = ?";
        Esquema obj = new Esquema();

        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                obj.setId(rs.getInt("Id"));
                obj.setNome(rs.getString("Nome"));
                obj.setLucro(rs.getDouble("Lucro"));
                // obj.getL1().setId(rs.getInt("LocalId"));
                //obj.getM1().setId(rs.getInt("MarcaId"));

                return obj;
            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return null;
    }

}
