package com.capgemini.bankapp.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bankapp.dto.TransferBean;
import com.capgemini.bankapp.entity.Account;
import com.capgemini.bankapp.exception.AccountException;
import com.capgemini.bankapp.service.AccountService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TransferController {

	@Autowired
	private AccountService accountService;

	@PutMapping("/update")
	public ResponseEntity<String> updateAccount(@RequestBody Account account) {
		System.out.println("Acc :"+account);
		try {
			accountService.updateAccount(account);
		} catch (Exception ex) {
			throw new AccountException("Account Not Updated.");// "Account Not Updated");
		}
		return new ResponseEntity<String>("Account Updated.", HttpStatus.OK);
	}

	@DeleteMapping("/del/{accId}")
	public ResponseEntity<String> delAccounts(@PathVariable("accId") Integer accId) {
		System.out.println("Acc ID:"+accId);
		try {
			accountService.delAccount(accId);
		} catch (Exception ex) {
			throw new AccountException(ex.getMessage());// "Account Not Deleted");
		}
		return new ResponseEntity<String>("Account Deleted.", HttpStatus.OK);
	}


	@GetMapping("/viewall")
	public ResponseEntity<List<Account>> getAccounts() {
		List<Account> accountList = accountService.viewAccount();
		return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
	}

	// @CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/add")
	public ResponseEntity<String> addAccount(@Valid @RequestBody Account account, BindingResult br)
			throws AccountException {
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new AccountException(err);
		}
		try {
			accountService.addAccount(account);
			return new ResponseEntity<String>("Account added", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new AccountException("ID already exists");
		}
	}

	// @CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/transfer")
	public ResponseEntity<String> transferAccount(@Valid @RequestBody TransferBean tbean, BindingResult br)
			throws AccountException {
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new AccountException(err);
		}
		accountService.transferFund(tbean.getFromAccountId(), tbean.getToAccountId(), tbean.getAmt());
		return new ResponseEntity<String>("Ammount Transferred", HttpStatus.OK);
	}
}
