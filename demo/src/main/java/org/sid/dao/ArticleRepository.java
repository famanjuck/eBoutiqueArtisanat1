package org.sid.dao;



import java.util.List;

import org.sid.reverse.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Integer>{
	@Query("select art from Article art where art.libellet like :x")
	public List<Article> chercher(@Param("x")String mc); 
	
	
	/*@Query("select art from Article art where art.libellet like :x")
	public List<Article> chercherArticleByArtisan(@Param("x")String mc); 
	
*/
}
