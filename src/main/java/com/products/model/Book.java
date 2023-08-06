package com.products.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@DiscriminatorValue("book")
public class Book extends Product{

}
