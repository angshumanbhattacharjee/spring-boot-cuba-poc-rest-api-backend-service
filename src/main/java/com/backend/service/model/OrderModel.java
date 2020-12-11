package com.backend.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@JsonInclude(value = Include.NON_NULL)
@Table(name = "sales_order")
@Entity
@Data
public class OrderModel implements Serializable {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "order_Id")
	private UUID orderId;

	@Column(name = "NUMBER_")
    protected String number;

    @Column(name = "DATE_")
    protected String date;

    @Column(name = "DESCRIPTION")
    protected String description;

    @Column(name = "ITEMS")
    protected String items;

}
