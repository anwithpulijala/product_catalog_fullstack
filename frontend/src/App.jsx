import React, { useState, useEffect } from "react";
import "./App.css";
import ProductList from "./ProductList";
import CategoryFilter from "./CategoryFilter";

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(""); // ✅ Default to empty string
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  // ✅ Fetch products and categories
  useEffect(() => {
    fetch("http://localhost:8080/api/products")
      .then((response) => response.json())
      .then((data) => {
        console.log("Fetched Products:", data);
        setProducts(Array.isArray(data) ? data : []);
      })
      .catch((error) => console.error("Error fetching products:", error));

    fetch("http://localhost:8080/api/categories")
      .then((response) => response.json())
      .then((data) => {
        console.log("Fetched Categories:", data);
        setCategories(Array.isArray(data) ? data : []);
      })
      .catch((error) => console.error("Error fetching categories:", error));
  }, []);

  // ✅ Handle Category Selection
  const handleCategorySelect = (categoryId) => {
    console.log("Selected Category:", categoryId);
    setSelectedCategory(categoryId);
  };

  // ✅ Handle Search Input
  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };

  // ✅ Handle Sorting Selection
  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  };

  // ✅ Filter Products
  const filteredProducts = products
    .filter((product) => {

      
      // ✅ If "All Categories" is selected, show all products
      if (selectedCategory === "" || selectedCategory === "all") {
        return true;
      }
      return product.category && product.category.id === Number(selectedCategory);
    })
    .filter((product) =>
      product.name.toLowerCase().includes(searchTerm.toLowerCase())
    )
    .sort((a, b) => (sortOrder === "asc" ? a.price - b.price : b.price - a.price));

  return (
    <div className="container">
      <h1 className="my-4">Product Catalog</h1>

      <div className="row align-items-center mb-4">
        

        {/* ✅ Search Bar */}
        <div className="col-md-3 col-sm-12 mb-2">
          <input
            type="text"
            className="form-control"
            placeholder="Search for products"
            value={searchTerm}
            onChange={handleSearchChange}
          />
        </div>

        {/* ✅ Sort Dropdown */}
        <div className="col-md-4 col-sm-12 mb-2">
          <select className="form-control" value={sortOrder} onChange={handleSortChange}>
            <option value="asc">Sort by Price: Low to High</option>
            <option value="desc">Sort by Price: High to Low</option>
          </select>
        </div>

        
        {/* ✅ Category Filter */}
        <div className="col-md-3 col-sm-12 mb-2">
          <CategoryFilter
            categories={categories}
            onSelect={handleCategorySelect}
            selectedCategory={selectedCategory}
          />
        </div>
      </div>

      {/* ✅ Display Products */}
      {filteredProducts.length > 0 ? (
        <ProductList products={filteredProducts} />
      ) : (
        <p>No Products Found</p>
      )}
    </div>
  );
}

export default App;