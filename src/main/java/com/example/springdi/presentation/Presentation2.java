package com.example.springdi.presentation;


import com.example.springdi.metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // Indique que cette classe contient des configurations Spring
@ComponentScan(basePackages = {"com.example.springdi.dao", "com.example.springdi.metier", "com.example.springdi.config"})  // Scanner aussi le package config
public class Presentation2 {
    public static void main(String[] args) {
        // Création du contexte Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // Activez un profil au besoin (dev/prod/file/api). Laisser vide pour la sélection par propriété.
        // context.getEnvironment().setActiveProfiles("dev");
        // context.getEnvironment().setActiveProfiles("prod");
        // context.getEnvironment().setActiveProfiles("file");
        // context.getEnvironment().setActiveProfiles("api");
        context.register(Presentation2.class);
        context.refresh();
        
        // Récupération du bean IMetier
        IMetier metier = context.getBean(IMetier.class);
        
        // Exécution et affichage du résultat
        System.out.println("Résultat = " + metier.calcul());
    }
}
