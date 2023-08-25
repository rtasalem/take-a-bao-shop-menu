import axios from "axios";
import { useEffect, useState } from "react";
import BaoziCard from "./BaoziCard";

const ListBaoziAPI = () => {
  const api = "http://localhost:8088/api/v1/menu-items";
  const [baoziList, setBaoziList] = useState([]);

  const loadBaozi = () => {
    axios
      .get(api)
      .then((response) => {
        console.log("Able to retrieve list of baozi from API.");
        setBaoziList(response.data);
      })
      .catch((error) =>
        console.log("Unable to retrieve list of baozi from API.")
      );
  };

  useEffect(() => {
    loadBaozi();
  }, []);

  return (
    <div>
      <div className="row row-cols-1 row-cols-md-2 g-4">
        {baoziList.map((item) => (
          <tr key={item.itemId}>
            <td>
              <BaoziCard
                itemName={item.itemName}
                itemDescription={item.itemDescription}
                itemPrice={item.itemPrice}
              />
            </td>
          </tr>
        ))}
      </div>
    </div>
  );
};
export default ListBaoziAPI;
