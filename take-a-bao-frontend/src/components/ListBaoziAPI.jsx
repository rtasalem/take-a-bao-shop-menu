import axios from "axios";
import { useEffect, useState } from "react";
import MenuItemCard from "./MenuItemCard";
import "../styles/ListMenuItemAPI.css";

const ListBaoziAPI = () => {
  const api = "http://localhost:8088/api/v1/menu-items/category/";
  const [baoziList, setBaoziList] = useState([]);

  const loadBaozi = (category) => {
    axios
      .get(api + category)
      .then((response) => {
        console.log("Successfully retrieved list of baozi from REST API.");
        setBaoziList(response.data);
      })
      .catch((error) =>
        console.log("Unable to retrieve list of baozi from REST API.")
      );
  };

  useEffect(() => {
    const category = "main";
    loadBaozi(category);
  }, []);

  return (
    <div className="row row-cols-1 row-cols-md-2 g-4">
      {baoziList.map((item) => (
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
export default ListBaoziAPI;
