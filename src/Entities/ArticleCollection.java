package Entities;
import java.util.ArrayList;

public class ArticleCollection {
    private static ArrayList<Article> articles = new ArrayList<>();

    public void create(Article article) {
        articles.add(article);
    }

    public Article read(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    public void update(Article article) {
        int index = articles.indexOf(article);
        if (index >= 0) {
            articles.set(index, article);
        }
    }

    public void delete(Article article) {
        articles.remove(article);
    }
    public static void getAll() {
        for (Article article : articles){
            System.out.println("ID : " + article.getId() + " NOM : " + article.getName() + " PRIX : " + article.getPrice());

        }
    }
    public static boolean checkId(int id){
        for (Article article : articles){
            if(article.getId() == id){
                return true;
            }
        }
        return false;
    }
    public static void articleRange(double firstPrice, double secondPrice){
        ArrayList<Article> matchingArticles = new ArrayList<Article>();
        for (Article article : articles){
            if(article.getPrice() >= firstPrice  && article.getPrice() <= secondPrice){
                matchingArticles.add(article);
                System.out.println("ID :" + article.getId() + " NOM : " + article.getName() + " PRIX : "+ article.getPrice());
            }

        }

    }
}


