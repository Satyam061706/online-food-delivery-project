package in.satyamsharma.foodiesapi.service;

import in.satyamsharma.foodiesapi.io.CartRequest;
import in.satyamsharma.foodiesapi.io.CartResponse;

public interface CartService {

    CartResponse addToCart(CartRequest request);

    CartResponse getCart();

    void clearCart();

    CartResponse removeFromCart(CartRequest cartRequest);
}
