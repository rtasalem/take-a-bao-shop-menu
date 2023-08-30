import axios from "axios";
import { useEffect, useState } from "react";
import "../styles/ListMenuItemAPI.css";
import MenuItemCard from "./MenuItemCard";

const ListSidesAPI = () => {
  const api = "http://localhost:8088/api/v1/menu-items/category/";
  const [sidesList, setSidesList] = useState([]);

  const loadSides = (category) => {
    axios
      .get(api + category)
      .then((response) => {
        console.log("Successfully retrieved list of sides from REST API.");
        setSidesList(response.data);
      })
      .catch((error) =>
        console.log("Unable to retrieve list of sides from REST API.")
      );
  };

  useEffect(() => {
    const category = "side";
    loadSides(category);
  }, []);

  return (
    <div className="row row-cols-1 row-cols-md-2 g-4">
      {sidesList.map((item) => (
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
export default ListSidesAPI;
