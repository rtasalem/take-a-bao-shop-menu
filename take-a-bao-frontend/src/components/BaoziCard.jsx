const BaoziCard = ({ itemName, itemDescription, itemPrice }) => {
  return (
    <div class="col">
      <div class="card">
        <img
          src="src/images/char-siu-bao.jpg"
          class="card-img-top"
          alt="Image of Char Siu Pork Bao (photo taken by [insert name - get info from Claire])"
        />
        <div class="card-body">
          <h5 class="card-title">{itemName}</h5>
          <p class="card-text">{itemDescription}</p>
          <p class="card-text">£{itemPrice}</p>
        </div>
      </div>
    </div>
  );
};
export default BaoziCard;
