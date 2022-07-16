package com.jameseng.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jameseng.dsmeta.entities.Sale;
import com.jameseng.dsmeta.services.SaleService;
import com.jameseng.dsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService smsService;

	/*
	 * @GetMapping public List<Sale> findSales() { return service.findSales(); }
	 */

	/*
	 * @GetMapping public Page<Sale> findSales(Pageable pageable) { return
	 * service.findSales(pageable); }
	 */

	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			Pageable pageable) {
		return service.findSales(minDate, maxDate, pageable);
	}
	
	/*@GetMapping("/notification")
	public void notifySms() {
		smsService.sendSms();
	}*/
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
	
	/*@GetMapping("/{id}/notification")
	public String notifySms(@PathVariable Long id) {
		return smsService.sendSms(id);
	}*/

}
