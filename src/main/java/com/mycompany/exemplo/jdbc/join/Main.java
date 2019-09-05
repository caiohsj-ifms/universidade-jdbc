/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exemplo.jdbc.join;

import java.util.List;

/**
 *
 * @author gustavo
 */
public class Main {
    public static void main(String[] args) throws Exception{
        ExemploSelectOO bd = new ExemploSelectOO();
        List<Cidade> cidades = bd.getCidades();
        
        for (Cidade cidade : cidades) {
            System.out.println(cidade.getId());
            System.out.println(cidade.getNome());
            System.out.println(cidade.getUf().getId());
            System.out.println(cidade.getUf().getNome());
            System.out.println(cidade.getUf().getSigla());
            System.out.println("-------------------------------");
        }
        
        UF uf = cidades.get(0).getUf();
        uf.setNome("TETA!!!!");
        System.out.println("Depois da alteração");
        
        for (Cidade cidade : cidades) {
            System.out.println(cidade.getId());
            System.out.println(cidade.getNome());
            System.out.println(cidade.getUf().getId());
            System.out.println(cidade.getUf().getNome());
            System.out.println(cidade.getUf().getSigla());
            System.out.println("-------------------------------");
        }
        
    }
}
