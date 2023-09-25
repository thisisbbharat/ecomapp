package com.cg.ecom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>
{

//	Iterable<Orders> findAll();
//	@Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM Orders o WHERE o.cart.cartId = :cartId")
//    boolean existsByCartId( int cartId);

//	 Iterable<Orders> findByCustomerId(Customers customerId);
//	 Iterable<Orders> findByProductSuppliers(ProductSupplier productSupplier);
//	 Iterable<Orders> findByCartId(String cartId);
//	 boolean existsById(Integer id);

}
//CrudRepository<Orders, Integer>