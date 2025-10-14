package com.example.springdi.presentation;


import com.example.springdi.metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // Indique que cette classe contient des configurations Spring
@ComponentScan(basePackages = {"com.example.springdi.dao", "com.example.springdi.metier"})  // Indique à Spring de scanner ces packages pour trouver des beans
public class Presentation2 {
    public static void main(String[] args) {
        // Création du contexte Spring avec activation du profil "dev"
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");  // Active le profil "dev"
        context.register(Presentation2.class);
        context.refresh();
        
        // Récupération du bean IMetier
        IMetier metier = context.getBean(IMetier.class);
        
        // Exécution et affichage du résultat
        System.out.println("Résultat = " + metier.calcul());
    }
}
