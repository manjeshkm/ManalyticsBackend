package com.ManaLytics.BackendManaLytics.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ManaLytics.BackendManaLytics.DTO.ProductDTO;

@Repository
public interface ProductsRepository extends JpaRepository<ProductDTO, Long> {
}
