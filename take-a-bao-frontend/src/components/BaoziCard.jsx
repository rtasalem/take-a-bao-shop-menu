const BaoziCard = ({ itemName, itemDescription, itemPrice }) => {
  return (
    <div className="baozi-card-container">
      <div className="baozi-card">
        <h2>{itemName}</h2>
        <p>{itemDescription}</p>
        <p>£{itemPrice}</p>
      </div>
    </div>
  );
};
export default BaoziCard;
