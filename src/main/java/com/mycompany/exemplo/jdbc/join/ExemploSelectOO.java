/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exemplo.jdbc.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class ExemploSelectOO {

    private Connection conn;

    public ExemploSelectOO() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection("jdbc:mysql://localhost/exemplo_join?user=root&password=&useTimezone=true&serverTimezone=UTC");
        conn.setAutoCommit(false);
    }

    public List<Cidade> getCidades() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * ");
        query.append("FROM cidade c ");
        query.append("INNER JOIN uf u ");
        query.append("ON (c.uf_id = u.id) ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        ResultSet rs = ps.executeQuery();

        HashMap<Integer, UF> estados = new HashMap<Integer, UF>();

        Integer idUf;
        Cidade cidade;
        UF uf;
        List<Cidade> cidades = new ArrayList<Cidade>();
        while (rs.next()) {
            idUf = rs.getInt("u.id");
            if (estados.containsKey(idUf)) {
                uf = estados.get(idUf);
            } else {
                uf = new UF();
                uf.setId(idUf);
                uf.setNome(rs.getString("u.nome"));
                uf.setSigla(rs.getString("u.sigla"));
                estados.put(idUf, uf);
            }
            cidade = new Cidade();
            cidade.setId(rs.getInt("c.id"));
            cidade.setNome(rs.getString("c.nome"));
            cidade.setUf(uf);
            cidades.add(cidade);
        }
        return cidades;
    }
}
