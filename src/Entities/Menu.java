package Entities;

import java.util.Scanner;

public class Menu {
    public static void choiceMenu(){

    ArticleCollection articleCollections = new ArticleCollection();
    Scanner scanner = new Scanner(System.in);

        while (true) {
        System.out.println("------------------Menu--------------------");
        System.out.println("1. Creer un article");
        System.out.println("2. Liste de tout les articles ");
        System.out.println("3. Mettre a jour un article ");
        System.out.println("4. Supprimmer un article");
        System.out.println("5. Rechercher un article par prix");
        System.out.println("6. Exit");

        System.out.print("Entrer votre choix: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Create
                System.out.print("Entrer l'ID de l'article : ");
                int id = scanner.nextInt();
                if (!ArticleCollection.checkId(id)){
                    scanner.nextLine();
                    System.out.print("Entrer un nom: ");
                    String name = scanner.nextLine();
                    System.out.print("Entrer un prix : ");
                    double price = Double.parseDouble(scanner.nextLine());

                    Article article = new Article();
                    article.setId(id);
                    article.setName(name);
                    article.setPrice(price);
                    articleCollections.create(article);
                    System.out.println("Article creer.");
                } else {
                    System.out.println("id deja existant");
                }

                break;

            case 2:
                // liste tout les articles
                System.out.print("Voici la liste de tout les articles : ");
                ArticleCollection.getAll();
                break;

            case 3:
                ArticleCollection.getAll();
               // UPDATE
                System.out.print("Entrer l'ID de l'article : ");
                int updateId = scanner.nextInt();
                Article updateArticle = articleCollections.read(updateId);
                if (updateArticle != null) {
                    scanner.nextLine();
                    System.out.print("Entrer un nouveau nom: ");
                    String newName = scanner.nextLine();
                    System.out.print("Entrer un nouveau prix: ");
                    double newPrice = Double.parseDouble(scanner.nextLine());

                    updateArticle.setName(newName);
                    updateArticle.setPrice(Double.parseDouble(String.valueOf(newPrice)));
                    articleCollections.update(updateArticle);
                    System.out.println("Article mis a jour.");
                } else {
                    System.out.println("Article non existant.");
                }
                break;

            case 4:
                ArticleCollection.getAll();
                // DELETE
                System.out.print("Entrer l'ID de l'article que vous voulez supprimer : ");
                int deleteId = scanner.nextInt();
                Article deleteArticle = articleCollections.read(deleteId);
                if (deleteArticle != null) {
                    articleCollections.delete(deleteArticle);
                    System.out.println("Article supprimer.");
                } else {
                    System.out.println("Article non existant.");
                }
                break;
            case 5:

                System.out.println("Entre ce prix ");
                int firstPrice = scanner.nextInt();
                System.out.println("Entre ce prix");
                int secondPrice = scanner.nextInt();
              ArticleCollection.articleRange(firstPrice, secondPrice );
                break;

            case 6:
                System.out.println("A bientot");
                return;

            default:

                System.out.println("Choix invalide.");
                break;
            }
        }
    }
}
