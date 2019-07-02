package org.sid.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.sid.dao.ArticleRepository;
import org.sid.reverse.Article;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@RestController
@CrossOrigin("*")

public class ArticleRest {
	
	@Autowired
	ServletContext context;
	@Autowired
	private ArticleRepository articleRepository;
	
//@RequestMapping(value ="/Article",method=RequestMethod.GET)
	public List<Article> getArticle(){
		return articleRepository.findAll();
	}
	

@RequestMapping(value = "/Article/{ref}", method = RequestMethod.GET)
	public Optional<Article> getArticle(@PathVariable("ref") int ref) {
		Optional<Article> article = articleRepository.findById(ref);
		article.get().setPhoto(this.getPhoto(article.get().getPhoto()));
		return article;
	}

@RequestMapping(value = "/Article", method = RequestMethod.GET)
List<Article> Article() {

	List<Article> articles = articleRepository.findAll();
	List<Article> realArticle = new ArrayList<>();
	for (Article article : articles) {
		article.setPhoto(this.getPhoto(article.getPhoto()));
		realArticle.add(article);
	}
	return realArticle;
}


/*@RequestMapping(value = "/ChercherArticleByUser", method = RequestMethod.GET)
List<Article> chercherArticleByArtisan(@RequestParam(name="mc",defaultValue="") String mc) {

	List<Article> articles = articleRepository.chercherArticleByArtisan(mc);
	List<Article> realArticle = new ArrayList<>();
	for (Article article : articles) {
		article.setPhoto(this.getPhoto(article.getPhoto()));
		realArticle.add(article);
	}
	return realArticle;
}*/

/*---------------------------------------------------------------------------------------------------------------*/

String getPhoto(String fileName) {
	String image = null;
	String filesPath = context.getRealPath("/images");
	File fileFolder = new File(filesPath);
	if (fileFolder != null) {
		for (final File file : fileFolder.listFiles()) {
			if (!file.isDirectory()) {
				String encodeBase64 = null;
				try {
					if (fileName.equals(file.getName())) {
						String extension = FilenameUtils.getExtension(file.getName());
						// String nom =
						// FilenameUtils.getBaseName(file.getName()) ;
						//System.out.println("nom photo = " + file.getName());
						FileInputStream fileInputStream = new FileInputStream(file);
						byte[] bytes = new byte[(int) file.length()];
						fileInputStream.read(bytes);
						encodeBase64 = Base64.getEncoder().encodeToString(bytes);
						image = "data:image/"+extension+";base64," + encodeBase64;
						fileInputStream.close();
					}
				} 
				catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	//System.out.println(image);
	return image;
}

	
/*---------------------------------------------------------------------------------------------------------------*/

@RequestMapping(value = "/Article", method = RequestMethod.POST)
public ResponseEntity<String> postArticle(@RequestParam("file1") MultipartFile file,
		@RequestParam("article") String article) throws JsonParseException, JsonMappingException, IOException {
	Article article2 = new ObjectMapper().readValue(article, Article.class);
	
	boolean isExist = new File(context.getRealPath("/images/")).exists();
	if (!isExist) {
		new File(context.getRealPath("/images/")).mkdir();
	}
	String fileName = file.getOriginalFilename();
	String modifyFileName = FilenameUtils.getBaseName(fileName)+"_"+System.currentTimeMillis()+"."
			+FilenameUtils.getExtension(fileName);
	File serverFile = new File(context.getRealPath("/images/"+File.separator+modifyFileName));
	try {
		FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
		System.out.println("Recupe photo");
	} catch (Exception e) {
		// TODO: handle exception
	}
	article2.setPhoto(modifyFileName);
	// personne2.setPhoto(file.getBytes());

	Article bdArticle = articleRepository.save(article2);
	//return bdArticle;
	System.out.println("Recupe photo1");
	

	if (bdArticle != null) {
		return new ResponseEntity<>("article is saved successfully", HttpStatus.OK);
	} else {
		return new ResponseEntity<>("article is not saved", HttpStatus.BAD_REQUEST);
	}
	

} 



/*@RequestMapping(value ="/Article",method=RequestMethod.POST)
public Article saveProduit(@RequestBody Article article){
	return articleRepository.save(article) ;
}*/

    @RequestMapping(value ="/chercherArticle",method=RequestMethod.GET)
	public List<Article> chercher(@RequestParam(name="mc",defaultValue="") String mc){ 
		List<Article> articles = articleRepository.chercher("%"+mc+"%") ;
		List<Article> realArticle = new ArrayList<>();
		for (Article article : articles) {
			article.setPhoto(this.getPhoto(article.getPhoto()));
			realArticle.add(article);
		}
		return realArticle;
	}
	
	@RequestMapping(value ="/Article/{ref}",method=RequestMethod.DELETE)
	public Boolean deleteProduit(@PathVariable("ref") int ref){
		articleRepository.deleteById(ref);
		return true ;
	}
	
	@RequestMapping(value ="/Article",method=RequestMethod.PUT)
	public Article updateProduit(@RequestBody Article article){
		article.setIdArticle(article.getIdArticle());
		return articleRepository.saveAndFlush(article) ;
	}

}
