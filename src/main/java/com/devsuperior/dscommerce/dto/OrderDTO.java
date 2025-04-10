package com.devsuperior.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;

public class OrderDTO {
	
	private Long id;
	private Instant moment;
	private OrderStatus status;
	
	private ClientDTO clientDTO;
	
	private PaymentDTO paymentDTO;
	
	private List<OrderItemDTO> items = new ArrayList<>();

	public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO clientDTO, PaymentDTO paymentDTO) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.clientDTO = clientDTO;
		this.paymentDTO = paymentDTO;
	}
	
	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.status = entity.getStatus();
		this.clientDTO = new ClientDTO(entity.getClient());
		this.paymentDTO = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
		for(OrderItem item : entity.getItems()) {
			OrderItemDTO itemDTO = new OrderItemDTO(item); 
			items.add(itemDTO);
		}
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public ClientDTO getClientDTO() {
		return clientDTO;
	}

	public PaymentDTO getPaymentDTO() {
		return paymentDTO;
	}

	public List<OrderItemDTO> getItens() {
		return items;
	}

	public Double getTotal() {
		double sum = 0;
		for(OrderItemDTO item: items) {
			sum += item.getSubTotal();
		}
		return sum;
	}
}
