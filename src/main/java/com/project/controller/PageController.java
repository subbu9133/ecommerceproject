package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.entity.Product;
import com.project.service.BasketService;
import com.project.service.CategoryService;
import com.project.service.ProductService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PageController {
	@Autowired
	private CategoryService cservice;

	@Autowired
	private ProductService pservice;

	@Autowired
	private BasketService basketService;

	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories", cservice.getAll());
		model.addAttribute("products", pservice.getAll());
		return "shop";
	}

	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model, @PathVariable("id") int id) {
		model.addAttribute("categories", cservice.getAll());
		model.addAttribute("products", pservice.getProByCatId(id));
		return "shop";
	}

	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model, @PathVariable("id") int id) {
		model.addAttribute("product", pservice.fetchbyId(id).get());
		return "viewProduct";
	}

	@GetMapping("/userform")
	public String form() {
		return "userform";
	}

	@GetMapping("/shop/addToBasket/{id}")
	public String addToBasket(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		Product product = pservice.fetchbyId(id).orElse(null);
		if (product != null) {
			basketService.addProduct(product);
		}

		// Add the basket size to the redirect attributes
		redirectAttributes.addFlashAttribute("basketSize", basketService.getBasketSize());

		return "redirect:/shop"; // Redirect back to shop after adding to basket
	}


	// View basket
	@GetMapping("/basket")
	public String viewBasket(Model model) {
		model.addAttribute("basket", basketService.getBasket());
		return "basket"; // Create a new basket.html page for displaying the basket
	}

	// Increase product quantity
	@GetMapping("/shop/increaseQuantity/{id}")
	public String increaseQuantity(@PathVariable("id") int id) {
		Product product = pservice.fetchbyId(id).orElse(null);
		if (product != null) {
			basketService.addProduct(product); // Adding product increases quantity
		}
		return "redirect:/basket"; // Redirect to basket view
	}

	// Decrease product quantity
	@GetMapping("/shop/decreaseQuantity/{id}")
	public String decreaseQuantity(@PathVariable("id") int id) {
		Product product = pservice.fetchbyId(id).orElse(null);
		if (product != null) {
			basketService.removeProduct(product); // Removing product decreases quantity
		}
		return "redirect:/basket"; // Redirect to basket view
	}
	// Payment form page
	@GetMapping("/shop/payment")
	public String paymentPage(Model model) {
		model.addAttribute("basket", basketService.getBasket());
		return "payment"; // Render 'payment.html'
	}

	// Process payment form submission
	@PostMapping("/shop/processPayment")
	public String processPayment(
			@RequestParam("cardName") String cardName,
			@RequestParam("cardNumber") String cardNumber,
			@RequestParam("expiryDate") String expiryDate,
			@RequestParam("cvv") String cvv,
			Model model) {

		// Simulate validation of the card details (for demo purposes)
		if (cardNumber.length() != 16 || cvv.length() != 3) {
			model.addAttribute("error", "Invalid card details. Please try again.");
			return "payment"; // Return to payment page with error
		}

		// Simulate successful payment (actual payment processing is not done)
		basketService.clearBasket(); // Clear the basket after "successful" payment
		model.addAttribute("message", "Payment successful. Your basket has been cleared.");
		return "paymentSuccess"; // Show payment success page
	}

	// Success page for payment
	@GetMapping("/shop/paymentSuccess")
	public String paymentSuccess(Model model) {
		model.addAttribute("message", "Payment successful. Thank you for your purchase!");
		return "paymentSuccess"; // Render 'paymentSuccess.html'
	}
}
