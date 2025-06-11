import React, { useState } from "react";
import { useCart } from "../context/CartContext";

const CheckoutPage = () => {
  const { cart, clearCart } = useCart();
  const [orderPlaced, setOrderPlaced] = useState(false);

  const handleCheckout = async () => {
    const orderData = { products: cart };

    // Send order to backend
    const response = await fetch("http://localhost:8080/api/orders", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(orderData),
    });

    if (response.ok) {
      setOrderPlaced(true);
      clearCart();
    }
  };

  return (
    <div>
      <h2>Checkout</h2>
      {orderPlaced ? (
        <p>Order placed successfully!</p>
      ) : (
        <>
          <ul>
            {cart.map((item) => (
              <li key={item.id}>
                {item.name} - ${item.price} x {item.quantity}
              </li>
            ))}
          </ul>
          <button onClick={handleCheckout}>Place Order</button>
        </>
      )}
    </div>
  );
};

export default CheckoutPage;
