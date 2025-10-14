package com.example.springdi.metier;

import com.example.springdi.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component("com/example/springdi/metier")  // Déclare cette classe comme un bean Spring avec l'identifiant "metier"
public class MetierImpl implements IMetier {

    // Injection de dépendance : Spring injectera automatiquement une implémentation de IDao
    @Autowired
    private IDao dao;  // Spring injectera le bean actif selon le profil

    @Override
    public double calcul() {
        // Utilise la méthode getValue() de l'implémentation injectée de IDao
        // et multiplie le résultat par 2
        return dao.getValue() * 2;
    }

    // Setter pour l'injection par setter (alternative à l'injection par champ)
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @PostConstruct
    private void init() {
        System.out.println("[TRACE] DAO injecté = " + dao.getClass().getSimpleName());
    }
}