package com.my.articles;

import com.my.articles.entity.Comment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class ArticlesApplicationTests {
	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {
		Comment comment = em.find(Comment.class, 1L);
		System.out.println("=================== "+comment.getArticle().getId());
	}

}
