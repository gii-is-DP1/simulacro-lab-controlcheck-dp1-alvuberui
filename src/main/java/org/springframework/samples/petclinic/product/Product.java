package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
	@Size(min = 3, max = 50)
	@NotNull
    String name;
	
	@Min(0)
	@NotNull
    double price;
	
	@NotNull
    @ManyToOne
	@JoinColumn(name = "productTypeId", referencedColumnName = "id")
    ProductType productType;
}
