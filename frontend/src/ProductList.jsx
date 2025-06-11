import React from "react";

const ProductList = ({ products }) => {
  return (
    <div className="row">
      {products.length > 0 ? (
        products.map((product) => {
          // ✅ Generate image path based on product name
          const imageUrl = `/images/${product.name.toLowerCase().replace(/\s+/g, "-")}.jpg`;

          return (
            <div className="col-lg-4 col-md-6 col-sm-12 mb-4" key={product.id}>
              <div className="card h-100">
                {/* ✅ Image with fallback handling */}
                <img
                  src={imageUrl}
                  className="card-img-top"
                  alt={product.name}
                  onError={(e) => {
                    e.target.src = "/images/default-placeholder.jpg"; // ✅ Fallback if image is not found
                  }}
                />

                <div className="card-body">
                  <h5 className="card-title">{product.name}</h5>
                  <p className="card-text">{product.description}</p>
                  <p className="card-text">
                    <strong>${product.price}</strong>
                  </p>

                  
                </div>
              </div>
            </div>
          );
        })
      ) : (
        <p className="text-center w-100">No products available.</p>
      )}
    </div>
  );
};

export default ProductList;
