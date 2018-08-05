package com.ManaLytics.BackendManaLytics.DAO;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import com.ManaLytics.BackendManaLytics.DTO.ProductDTO;
import com.ManaLytics.BackendManaLytics.Repo.ProductsRepository;

@Component
@Transactional
public class ProductDAO {
	private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);
	@Autowired
	private ProductsRepository productrepo;

	@PersistenceContext
	private EntityManager em;

	public Page<ProductDTO> getallProducts(Pageable pagerequest) {

		return productrepo.findAll(pagerequest);
		// java.util.List<ProductDTO> list = new ArrayList<>();
		// Iterable<ProductDTO> customers = productrepo.findAll();
		//
		// customers.forEach(list::add);
		// return list;
		// return productrepo.findAll();
	}

	public ProductDTO getProductById(Long id) {

		ProductDTO prod = productrepo.findById(id).get();
		logger.info("prod id=" + id + "product=" + prod);
		return prod;
	}

	public ProductDTO creatProduct(ProductDTO dto) {
		logger.info("saving product=" + dto);
		ProductDTO saved = productrepo.save(dto);
		logger.info("saved=" + saved);
		return saved;
	}
	
	public void deleteById(Long id) {
		logger.info("Deleting prod of id=" + id);
		productrepo.deleteById(id);
	}

	public void updateProductQuantity(Long id, float f) {
		Query query = em.createNativeQuery("update Products_Table set Pqvalue=:quantity WHERE id=:id");
		query.setParameter("quantity", f);
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
