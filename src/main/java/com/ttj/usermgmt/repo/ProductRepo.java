package com.ttj.usermgmt.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ttj.usermgmt.entity.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, BigInteger>{

}
