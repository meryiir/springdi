package com.example.springdi.dao;

import org.springframework.stereotype.Component;

@Component("dao2")  // Déclare cette classe comme un bean Spring avec l'identifiant "dao2"
public class DaoImpl2 implements IDao {
    @Override
    public double getValue() {
        // Cette implémentation alternative retourne 150.0
        return 150.0;
    }
}