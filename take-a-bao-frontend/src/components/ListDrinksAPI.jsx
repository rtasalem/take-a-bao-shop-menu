import axios from "axios";
import { useEffect, useState } from "react";
import MenuItemCard from "./MenuItemCard";

const ListDrinksAPI = () => {
  const api = "http://localhost:8080/api/v1/menu-items/category/";
  const [drinksList, setDrinksList] = useState([]);

  const loadDrinks = (category) => {
    axios
      .get(api + category)
      .then((response) => {
        console.log("Successfully retrieved list of drinks from REST API.");
        setDrinksList(response.data);
      })
      .catch((error) =>
        console.log("Unable to retrieve list of drinks from REST API.")
      );
  };

  useEffect(() => {
    const category = "drink";
    loadDrinks(category);
  }, []);

  return (
    <div className="row row-cols-1 row-cols-md-2 g-4">
      {drinksList.map((item) => (
        <tr key={item.itemId}>
          <td>
            <MenuItemCard
              itemName={item.itemName}
              itemDescription={item.itemDescription}
              itemPrice={item.itemPrice}
              itemImage={item.itemImage}
            />
          </td>
        </tr>
      ))}
    </div>
  );
};
export default ListDrinksAPI;
