import axios from "axios";
import { useEffect, useState } from "react";
import MenuItemCard from "./MenuItemCard";

const ListDessertsAPI = () => {
  const api = "http://localhost:8088/api/v1/menu-items/category/";
  const [dessertsList, setDessertsList] = useState([]);

  const loadDesserts = (category) => {
    axios
      .get(api + category)
      .then((response) => {
        console.log("Successfully retrieved list of sides from REST API.");
        setDessertsList(response.data);
      })
      .catch((error) =>
        console.log("Unable to retrieve list of desserts from REST API.")
      );
  };

  useEffect(() => {
    const category = "dessert";
    loadDesserts(category);
  }, []);

  return (
    <div className="row row-cols-1 row-cols-md-2 g-4">
      {dessertsList.map((item) => (
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
export default ListDessertsAPI;
