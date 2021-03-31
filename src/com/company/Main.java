package com.company;

import DAO.*;
import Modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main {

   /* public static void main(String[] args) {
//////////////////////////////////////////////////////////pessoa////////////////////////////////////////////////////////////////////
        Pessoa p1=new Pessoa();
        p1.setCpf("654546546546");
        p1.setNome("ze");
        p1.setGanho(45454.0);
        p1.setNivel(1);
        p1.setCara_acima(null);

        Pessoa p2=new Pessoa();
        p2.setCpf("3434546546");
        p2.setNome("jao");
        p2.setGanho(45454.0);
        p2.setNivel(2);
        p2.setCara_acima(p1);

        DAOPessoa dp=new DAOPessoa();

        dp.salvar(p1);
        dp.salvar(p2);




        for (Pessoa pessoa: dp.getLista())
        {
            System.out.println(pessoa);
            System.out.println("\n");
        }

        System.out.println("\n\n\n");


//////////////////////////////////////////////////////////esquema/////////////////////////////////////////////////////////////////////


        Esquema e1=new Esquema();

        e1.setNome("i have no name");
        e1.setLucro(78787.0);

        Esquema e2=new Esquema();

        e2.setNome("ahhhhh");
        e2.setLucro(7457.0);

        DAOEsquema de=new DAOEsquema();
        de.salvar(e1);
        de.salvar(e2);

        for(Esquema esquema: de.getEsquema())
        {
            System.out.println(esquema);
            System.out.println("\n");
        }
        System.out.println("\n\n\n");

///////////////////////////////////////////////////////////////////////////marca///////////////////////////////////////////////////////////////////////////////


        Marca m1=new Marca();
        Marca m2=new Marca();

        m1.setNome("jequiti");
        m1.setTipo("ganhar money");

        m2.setNome("hinode");
        m2.setTipo("ganhar money");

        DAOMarca dm=new DAOMarca();

        dm.salvar(m1);
        dm.salvar(m2);

        for (Marca marca: dm.getmarca())
        {
            System.out.println(marca);
            System.out.println("\n");
        }
        System.out.println("\n\n\n");



///////////////////////////////////////////////////////////////////marca_esquema////////////////////////////////////////////////////////////////////////////




        Marca_Esquema me1=new Marca_Esquema();
        me1.setM1(m1);
        me1.setE1(e1);


        Marca_Esquema me2=new Marca_Esquema();
        me2.setM1(m2);
        me2.setE1(e2);



        DAOMarca_Esquema dme=new DAOMarca_Esquema();
        dme.salvar(me1);
        dme.salvar(me2);


        for (Marca_Esquema marcaEsquema: dme.getmarcaesquema())
        {
            System.out.println(marcaEsquema + "\n");
        }
        System.out.println("\n\n\n");


///////////////////////////////////////////////////////pessoa_esquema///////////////////////////////////////////////////////////


        Pessoa_Esquema pe1=new Pessoa_Esquema();
        pe1.setP1(p1);
        pe1.setE1(e1);

        Pessoa_Esquema pe2=new Pessoa_Esquema();
        pe2.setP1(p2);
        pe2.setE1(e2);

        DAOPessoa_Esquema dpe=new DAOPessoa_Esquema();
        dpe.salvar(pe1);
        dpe.salvar(pe2);

        for (Pessoa_Esquema pessoaEsquema: dpe.getpessoaesquema())
        {
            System.out.println(pessoaEsquema + "\n");
        }
        System.out.println("\n\n\n");




//////////////////////////////////////////////////////////////local///////////////////////////////////////////////////////////


        Local l1=new Local();

        l1.setEstado("MG");
        l1.setCidade("BH");

        Local l2=new Local();

        l2.setCidade("SJE");
        l2.setEstado("MG");

        DAOLocal dl=new DAOLocal();

        dl.salvar(l1);
        dl.salvar(l2);

        for (Local local: dl.getlocal())
        {
            System.out.println(local + "\n");
        }

        System.out.println("\n\n\n");


////////////////////////////////////////////////////////dependente/////////////////////////////////////////////////////////////

        Dependente d1=new Dependente();

        d1.setNome("enzo");
        d1.setP1(p1);

        Dependente d2=new Dependente();

        d2.setNome("valentina");
        d2.setP1(p2);

        DAODependente dd=new DAODependente();

        dd.salvar(d1);
        dd.salvar(d2);

        for (Dependente dependente: dd.getdependente())
        {
            System.out.println(dependente + "\n");
        }

        System.out.println("\n\n\n");




////////////////////////////////////////////////////////localdependente/////////////////////////////////////////////////////////


        LocalDependente ld1=new LocalDependente();

        ld1.setD1(d1);
        ld1.setL1(l1);

        LocalDependente ld2=new LocalDependente();

        ld2.setD1(d2);
        ld2.setL1(l2);

        DAOLocal_Dependente dld=new DAOLocal_Dependente();

        dld.salvar(ld1);
        dld.salvar(ld2);

        for (LocalDependente localDependente: dld.getlocaldependente())
        {
            System.out.println(localDependente + "\n");
        }

        System.out.println("\n\n\n");


//////////////////////////////////////////////////////////////localpessoa///////////////////////////////////////////////////////


        LocalPessoa lp1=new LocalPessoa();

        lp1.setL1(l1);
        lp1.setP1(p1);

        LocalPessoa lp2=new LocalPessoa();

        lp2.setL1(l2);
        lp2.setP1(p2);


        DAOLocal_Pessoa dlp=new DAOLocal_Pessoa();

        dlp.salvar(lp1);
        dlp.salvar(lp2);

        for (LocalPessoa localPessoa: dlp.getlocalpessoa())
        {
            System.out.println(localPessoa + "\n");
        }

        System.out.println("\n\n\n");


///////////////////////////////////////////////////////////////////localesquema////////////////////////////////////////////////////////////////////////////////


        LocalEsquema le1=new LocalEsquema();

        le1.setE1(e1);
        le1.setL1(l1);

        LocalEsquema le2=new LocalEsquema();

        le2.setE1(e2);
        le2.setL1(l2);

        DAOLocal_Esquema dle=new DAOLocal_Esquema();

        dle.salvar(le1);
        dle.salvar(le2);

        for (LocalEsquema localEsquema: dle.getlocalesquema())
        {
            System.out.println(localEsquema + "\n");
        }


    }*/
    
    
    
    public static void main(String[] args)
    {
     
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
    }
}
