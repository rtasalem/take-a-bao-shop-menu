import "../styles/BaoziCard.css";

const BaoziCard = ({ itemName, itemDescription, itemPrice }) => {
  return (
    <div className="col">
      <div className="card">
        <img
          src="./images/char-siu-bao.jpg"
          className="card-img-top"
          alt="Image of Char Siu Pork Bao (photo taken by [insert name - get info from Claire])"
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
export default BaoziCard;
