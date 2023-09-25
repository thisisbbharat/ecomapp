package com.cg.ecom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>
{


	
	 @Query("SELECT SUM(ci.productItems.price * ci.quantity) FROM Cart ci " +
	           "WHERE ci.customers.customerId = :customerId")
	    Long findTotalPriceByCustomerId(int customerId);
	 
//	 @Modifying
//	 @Query("UPDATE ProductItems p SET p.quantity = p.quantity - (SELECT o.quantity FROM Cart c JOIN c.productItems o WHERE c.customers.customerId = :customerId AND o.productId = p.productId)")
//	 void updateProductItemsQuantityByCustomerId(int customerId);

//	 @Query("SELECT SUM(ci.productItems.price * ci.quantity) FROM Cart ci " +
//		       "JOIN ci.productItems pi JOIN ci.customers c JOIN ci.cartId.cartItems oi JOIN oi.orderId o JOIN o.payment p " +
//		       "WHERE o.orderId = :orderId AND c.customerId = p.cartId.customers.customerId")
//		Long findTotalPriceByOrderId(int orderId);



}


