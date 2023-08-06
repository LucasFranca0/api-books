package com.products.service;

import com.products.dto.SaleDTO;
import com.products.model.Sale;

public interface SaleService {
    Sale createSale(SaleDTO saleDTO);
}
