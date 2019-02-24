package com.baie.search;

import com.baie.search.entity.Brand;
import com.baie.search.entity.Product;
import com.baie.search.service.BrandService;
import com.baie.search.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandServiceTest {

	@Autowired
	private BrandService brandService;

//	@Test
//	public void addBrand() {
//		Brand brand = Brand.builder().name("brand1").description("first brand").title("brand1_title").build();
//		boolean status = brandService.addBrand(brand);
//		assertThat(status).isTrue();
//	}

//	@Test
//	public void deleteBrand() {
//		String id = "JJSt0mgBzMWG6hWft22Z";
//		boolean status = brandService.deleteBrand(id);
//		assertThat(status).isTrue();
//	}

	@Test
	public void update() {
		Brand brand = Brand.builder().id("Bos-1WgBg3o9eEdX-Avj1").name("brand2").description("secondary brand").title("brand2_title").build();
		boolean status = brandService.update(brand);
		assertThat(status).isTrue();
	}

//	@Test
//	public void deleteBrands() {
//		boolean status = brandService.deleteAll();
//		assertThat(status);
//	}

}

