package com.jameseng.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jameseng.dsmeta.entities.Sale;
import com.jameseng.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	/*
	 * public List<Sale> findSales() { return repository.findAll(); }
	 */

	/*
	 * public Page<Sale> findSales(Pageable pageable) { return
	 * repository.findAll(pageable); }
	 */

	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {

		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		// Instant.now() = instante atual
		// ZoneId.systemDefault() = fuso horário

		// LocalDate min = LocalDate.parse(maxDate); // converte String para localDate
		// do Java
		// today.minusDays(365) = data de hoje, mas há um ano atrás
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

		return repository.findSales(min, max, pageable);
	}

}
