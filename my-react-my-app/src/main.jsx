import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "bootstrap/dist/css/bootstrap.min.css"; // ✅ Ensure Bootstrap loads first
import "./index.css"; 
import App from "./App.jsx";
import { CartProvider } from "./CartContext"; // ✅ Import Cart Context Provider

const rootElement = document.getElementById("root");

if (!rootElement) {
  throw new Error("Root element not found. Make sure <div id='root'></div> exists in index.html");
}

createRoot(rootElement).render(
  <StrictMode>
    <CartProvider> {/* ✅ Wrap the App with CartProvider */}
      <App />
    </CartProvider>
  </StrictMode>
);

