package org.example.serviceexcersice.Service;

import org.example.serviceexcersice.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class NewsArticleService {
    ArrayList<NewsArticle> news= new ArrayList<>();
    public ArrayList<NewsArticle> getArticles() {
        return news;
    }

    public void addArticle(NewsArticle newsArticle){
        news.add(newsArticle);
    }

    public boolean updateArticle(int id , NewsArticle newsArticle){
        for (int i = 0; i <news.size() ; i++) {
            if(news.get(i).getId()==id){
                news.set(i,newsArticle);
                return true;
            }
        }
        return false;
    }

    public boolean deleteArticle(int id ){
        for (int i = 0; i <news.size() ; i++) {
            if(news.get(i).getId()==id){
                news.remove(i);
                return true;
            }
        }
        return false;
    }

    public NewsArticle publishArticles(int id){
        for (int i = 0; i <news.size() ; i++) {
            if(news.get(i).getId()==id){
                news.get(i).setPublished(true);
                news.get(i).setPublishDate(LocalDate.now());
                return news.get(i);
            }
        }
        return null;
    }

    public NewsArticle getPublished(){
        for (int i = 0; i < news.size() ; i++) {
            if(news.get(i).isPublished()){
                return news.get(i);
            }
        }
        return null;
    }

    public NewsArticle searchCategory(String category){
        for (int i = 0; i < news.size() ; i++) {
            if(news.get(i).getCategory().equalsIgnoreCase(category)){
                return news.get(i);
            }
        }
        return null;
    }



}
