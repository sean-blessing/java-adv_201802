package com.pma.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pma.business.Invoice;
import com.pma.business.InvoiceRepository;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
	
	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@GetMapping(path="/")
	public Iterable<Invoice> getAll() {
		return invoiceRepo.findAll();
		
	}

}
