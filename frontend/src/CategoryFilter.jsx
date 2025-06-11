const CategoryFilter = ({ categories, onSelect, selectedCategory }) => {
    return (
      <select
        id="categorySelect"
        className="form-control"
        onChange={(e) => onSelect(e.target.value)}
        value={selectedCategory}
      >
        <option value="all">All Categories</option>
        {categories.map((category) => (
          <option key={category.id} value={category.id}>
            {category.name}
          </option>
        ))}
      </select>
    );
  };
  
  export default CategoryFilter;
  