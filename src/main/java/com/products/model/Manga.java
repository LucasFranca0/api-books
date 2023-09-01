package com.products.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("manga")
public class Manga extends Product{
    @Override
    public String getProductType() {
        return "manga";
    }

}
