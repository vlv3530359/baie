package com.baie.search;

import com.baie.search.entity.Product;
import com.baie.search.service.ProductService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	@Autowired
	private ProductService productService;

	@Before
	public void init() {
		int i=1;
		Product product;
		boolean status = true;
		while (i<100) {
			product = Product.builder().name("product"+i).description("description"+i).title("title"+i).build();
			if(!productService.addProduct(product)) {
				status = false;
			}
			i ++;
		}
	}

	@After
	public void deleteProducts() {
		boolean status = productService.deleteAll();
		assertThat(status);
	}

	@Test
	public void queryById() {
		Product product = Product.builder().id("1").name("product").description("description").title("title").build();
		productService.addProduct(product);
		Optional<Product> productOptional = productService.queryById("1");
		assertThat(productOptional.get()).isNotNull();
	}

	@Test
	public void queryByBoolean() {
		Iterable<Product> product = productService.queryByBoolean("product1");
		Iterator itr = product.iterator();
		assertThat(itr.hasNext()).isTrue();
	}

	@Test
	public void queryByTerm() {
		Iterable<Product> product = productService.queryByTermAndSortWithPaging("name", "product2");
		Iterator itr = product.iterator();
		assertThat(itr.hasNext()).isTrue();
	}

	@Test
	public void queryByPaging() {

	}

}

