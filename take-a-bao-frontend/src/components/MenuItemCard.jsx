import "../styles/MenuItemCard.css";

const MenuItemCard = ({ itemName, itemDescription, itemPrice, itemImage }) => {
  return (
    <div className="col">
      <div className="card">
        <img
          src={itemImage}
          className="card-img-top"
          alt="Image of ${itemName} Bao (photo taken by [insert name - get info from Claire])"
        />
        <div className="card-body">
          <h5 className="card-title">{itemName}</h5>
          <p className="item-description">{itemDescription}</p>
          <p className="item-price">
            <b>£{itemPrice}</b>
          </p>
        </div>
      </div>
    </div>
  );
};
export default MenuItemCard;
