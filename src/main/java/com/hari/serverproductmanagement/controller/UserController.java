package com.hari.serverproductmanagement.controller;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hari.serverproductmanagement.jwt.JwtTokenProvider;
import com.hari.serverproductmanagement.model.Role;
import com.hari.serverproductmanagement.model.Transaction;
import com.hari.serverproductmanagement.model.User;
import com.hari.serverproductmanagement.service.ProductService;
import com.hari.serverproductmanagement.service.TransactionService;
import com.hari.serverproductmanagement.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private UserService userService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/api/user/registration")
	public ResponseEntity<?> register(@RequestBody User user) {
		if(userService.findByUsername(user.getUsername())!=null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		//set user Role
		user.setRole(Role.USER);
		return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED); 
	}
	
	@GetMapping("/api/user/login")
	public ResponseEntity<?> getUser(Principal principal) {
		if(principal == null) {
			return ResponseEntity.ok(principal);
		}
		UsernamePasswordAuthenticationToken authenticationToken = 
				(UsernamePasswordAuthenticationToken) principal;
		User user = userService.findByUsername(authenticationToken.getName());
		user.setToken(jwtTokenProvider.generateToken(authenticationToken));
		return new ResponseEntity<>(user, HttpStatus.OK); 
	}
	
	@PostMapping("/api/user/purchase")
	public ResponseEntity<?> purchaseProduct(@RequestBody Transaction transaction) {
		transaction.setPurchaseDate(LocalDateTime.now());
		return new ResponseEntity<>(transactionService.saveTransaction(transaction),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/user/products")
	public ResponseEntity<?> getAllProducts() {
		return new ResponseEntity<>(productService.findAllProducts(),HttpStatus.OK);
	}
	
}
