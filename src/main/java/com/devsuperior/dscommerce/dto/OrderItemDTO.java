package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrderItemDTO {
	
	private Long productId;
	private String name;
	private Double price;
	private Integer quantity;
	private String imgUrl;
	
	public OrderItemDTO(Long productId, String name, Double price, Integer quantity, String imgUrl) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.imgUrl = imgUrl;
	}
	
	public OrderItemDTO(OrderItem entity) {
		this.productId = entity.getProduct().getId();
		this.name = entity.getProduct().getName();
		this.price = entity.getProduct().getPrice();
		this.quantity = entity.getQuantity();
		this.imgUrl = entity.getProduct().getImgUrl();
	}

	public Long getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	public Double getSubTotal() {
		return this.price * this.quantity;
	}

	public String getImgUrl() {
		return imgUrl;
	}
}
