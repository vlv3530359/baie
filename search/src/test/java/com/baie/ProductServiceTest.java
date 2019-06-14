package com.baie;

import com.baie.core.module.ProductData;
import com.baie.service.ProductService;
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
		ProductData productData;
		boolean status = true;
		while (i<100) {
			productData = ProductData.builder().id(Long.valueOf(i)).productName("product"+i).longDescription("description"+i).categoryId("category"+i).build();
			if(!productService.addProduct(productData)) {
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
		ProductData productData = ProductData.builder().id(1L).productName("product").longDescription("description").categoryId("category").build();
		productService.addProduct(productData);
		Optional<ProductData> productOptional = productService.queryById(1L);
		assertThat(productOptional.get()).isNotNull();
	}

	@Test
	public void queryByBoolean() {
		Iterable<ProductData> productData = productService.queryByBoolean("product1");
		Iterator itr = productData.iterator();
		assertThat(itr.hasNext()).isTrue();
	}

	@Test
	public void queryByTerm() {
		Iterable<ProductData> productData = productService.queryByTermAndSortWithPaging("productName", "product2");
		Iterator itr = productData.iterator();
		assertThat(itr.hasNext()).isTrue();
	}

	@Test
	public void queryByPaging() {

	}

}

