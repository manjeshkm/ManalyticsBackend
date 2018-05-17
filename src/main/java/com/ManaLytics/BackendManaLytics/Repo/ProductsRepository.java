package com.ManaLytics.BackendManaLytics.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ManaLytics.BackendManaLytics.DTO.ProductDTO;

@RepositoryRestResource
public interface ProductsRepository extends JpaRepository<ProductDTO, Long> {

}
