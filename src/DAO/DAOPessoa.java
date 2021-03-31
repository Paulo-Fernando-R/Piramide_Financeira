package DAO;

import Modelo.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOPessoa
{

    public List<Pessoa> getLista()
    {
        String sql = "select * from pessoa";
        List<Pessoa> lista = new ArrayList<>();
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Pessoa obj = new Pessoa();
                obj.setId(rs.getInt("Id"));
                obj.setNome(rs.getString("Nome"));
                obj.setNivel(rs.getInt("Nivel"));
                obj.setGanho(rs.getDouble("Ganho"));
                obj.setCpf(rs.getString("CPF"));
                obj.setCara_acima(DAOPessoa.localizar(rs.getInt("CaraAcima")));

                obj.setL1(DAOLocal.localizar(rs.getInt("LocalId")));
                obj.setE1(DAOEsquema.localizar(rs.getInt("EsquemaId")));

                lista.add(obj);

            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return lista;
    }

    public boolean salvar(Pessoa obj)
    {
        if (obj.getId() == null)
        {
            if (!(obj.getCara_acima() == null))
            {
                return incluir(obj);
            } else
            {

                return incluir2(obj);
            }

        } else
        {
            if (!(obj.getCara_acima() == null))
            {
                return alterar(obj);
            } else
            {

                return alterar2(obj);
            }

        }
    }

    public boolean incluir2(Pessoa obj)
    {

        String sql = "insert into pessoa (Nome, Nivel , Ganho, CPF, LocalId, EsquemaId) values(?,?,?,?,?,?)";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setDouble(2, obj.getNivel());
            pst.setDouble(3, obj.getGanho());
            pst.setString(4, obj.getCpf());
            pst.setInt(5, obj.getL1().getId());
            pst.setInt(6, obj.getE1().getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Pessoa incluida com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Pessoa não incluida com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean incluir(Pessoa obj)
    {

        String sql = "insert into pessoa (Nome, Nivel , Ganho, CPF, CaraAcima, LocalId, EsquemaId) values(?,?,?,?,?,?,?)";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setDouble(2, obj.getNivel());
            pst.setDouble(3, obj.getGanho());
            pst.setString(4, obj.getCpf());
            pst.setInt(5, obj.getCara_acima().getId());
            pst.setInt(6, obj.getL1().getId());
            pst.setInt(7, obj.getE1().getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Pessoa incluida com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Pessoa não incluida com sucesso");
                return false;
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + "Você não pode adicionar uma pessoa como 'Cara Acima' dela mesma sem tê-la salvo antes");
            return false;
        }
    }

    public boolean alterar(Pessoa obj)
    {
        String sql = "update pessoa set Nome = ?, Nivel = ?, Ganho = ?, CPF = ?, CaraAcima = ?,LocalId = ?, EsquemaId = ? where Id = ?";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setDouble(2, obj.getNivel());
            pst.setDouble(3, obj.getGanho());
            pst.setString(4, obj.getCpf());
            pst.setInt(5, obj.getCara_acima().getId());
            pst.setInt(6, obj.getL1().getId());
            pst.setInt(7, obj.getE1().getId());
            pst.setInt(8, obj.getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Pessoa não alterada com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }

    }

    public boolean alterar2(Pessoa obj)
    {
        String sql = "update pessoa set Nome = ?, Nivel = ?, Ganho = ?, CPF = ?, LocalId = ?, EsquemaId = ? where Id = ?";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setDouble(2, obj.getNivel());
            pst.setDouble(3, obj.getGanho());
            pst.setString(4, obj.getCpf());
            pst.setInt(5, obj.getL1().getId());
            pst.setInt(6, obj.getE1().getId());
            pst.setInt(7, obj.getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso");
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Pessoa não alterada com sucesso");
                return false;
            }

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }

    }

    public boolean remover(Pessoa obj)
    {
        desativar();
        String sql = "delete from pessoa where Id = ?";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getId());
            if (pst.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Pessoa excluida com sucesso");
                ativar();
                return true;
            } else
            {
                JOptionPane.showMessageDialog(null, "Pessoa não excluida com sucesso");
                return false;
            }

        } catch (SQLException e)
        {

            JOptionPane.showMessageDialog(null, "Erro de SQL: " + "Este registro está sendo usado em outra tabela");
            return false;
        }

    }

    public void desativar()
    {
        String sql = "SET foreign_key_checks = 0";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.executeUpdate();

        } catch (SQLException e)
        {

        }
    }

    public void ativar()
    {
        String sql = "SET foreign_key_checks = 1";
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.executeUpdate();

        } catch (SQLException e)
        {

        }
    }

    public static Pessoa localizar(Integer id)
    {
        String sql = "select * from pessoa where Id = ?";
        Pessoa obj = new Pessoa();
        try
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                obj.setId(rs.getInt("Id"));
                obj.setNome(rs.getString("Nome"));
                obj.setNivel(rs.getInt("Nivel"));
                obj.setGanho(rs.getDouble("Ganho"));
                obj.setCpf(rs.getString("CPF"));

                return obj;
            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return null;
    }

}
