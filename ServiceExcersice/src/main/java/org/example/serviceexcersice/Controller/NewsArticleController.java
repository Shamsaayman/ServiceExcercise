package org.example.serviceexcersice.Controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.serviceexcersice.Api.ApiResponse;
import org.example.serviceexcersice.Model.NewsArticle;
import org.example.serviceexcersice.Service.NewsArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;



import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class NewsArticleController {
private final NewsArticleService newsArticleService;

    @GetMapping("/get")
    public ResponseEntity getArticle(){
        ArrayList<NewsArticle> news=newsArticleService.getArticles();
        return ResponseEntity.status(200).body(news);
    }
    @PostMapping("/add")
    public ResponseEntity addArticle(@RequestBody @Valid NewsArticle newsArticle , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        newsArticleService.addArticle(newsArticle);
        return ResponseEntity.status(200).body(new ApiResponse("Article Added"));

    }

@PutMapping("/update/{id}")
public ResponseEntity updateArticle(@PathVariable int id , @RequestBody @Valid NewsArticle newsArticle , Errors errors){
    if (errors.hasErrors()) {
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    boolean isUpdated= newsArticleService.updateArticle(id,newsArticle);
    if(isUpdated){
        return ResponseEntity.status(200).body(new ApiResponse("Article Updated"));
    }
    return ResponseEntity.status(400).body(new ApiResponse("Article Doesn't Exist"));
}

@DeleteMapping("/delete/{id}")
public ResponseEntity deleteArticle( @PathVariable int id){
    boolean isDeleted= newsArticleService.deleteArticle(id);
    if(isDeleted){
        return ResponseEntity.status(200).body(new ApiResponse("Article Deleted"));
    }
    return ResponseEntity.status(400).body(new ApiResponse("Article Doesn't Exist"));
}


@PutMapping("/publish/{id}")
    public ResponseEntity publishArticle( @PathVariable int id){

        if( newsArticleService.publishArticles(id)==null){
            return ResponseEntity.status(400).body(new ApiResponse("Article Doesn't Exist"));
        }
        return ResponseEntity.status(200).body(newsArticleService.publishArticles(id));
    }

@GetMapping("/getpublished")
    public ResponseEntity getPublished(){
        if(newsArticleService.getPublished()==null){
            return ResponseEntity.status(400).body(new ApiResponse("No Published Articles"));
        }
        return ResponseEntity.status(200).body(newsArticleService.getPublished());
    }

@GetMapping("/search/{category}")
    public ResponseEntity SearchArticle( @PathVariable String category){
        if(newsArticleService.searchCategory(category)==null){
            return ResponseEntity.status(400).body(new ApiResponse("Article Category doesn't exist"));
        }
        return ResponseEntity.status(200).body(newsArticleService.searchCategory(category));
    }




























}
