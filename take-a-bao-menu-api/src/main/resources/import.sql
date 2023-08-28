--Main Menu (BAOZI):
INSERT INTO MenuItem (itemId, itemName, itemDescription, itemPrice, itemCategory, suitableForVegetarians) VALUES (nextval('ITEM_ID_SEQ'), 'Char Siu Pork', 'A family recipe, tender buns cradle Chinese barbecue pork, blending savory and sweet flavours for an exquisite delight.', 3.00, 'main', false);
INSERT INTO MenuItem (itemId, itemName, itemDescription, itemPrice, itemCategory, suitableForVegetarians) VALUES (nextval('ITEM_ID_SEQ'), 'Chicken', 'Delicate buns embrace seasoned chicken, aromatic ginger, and fresh scallions. An enticing fusion that captivates the taste buds.', 3.00, 'main', false);
INSERT INTO MenuItem (itemId, itemName, itemDescription, itemPrice, itemCategory, suitableForVegetarians) VALUES (nextval('ITEM_ID_SEQ'), 'Gochujang Tofu', 'Soft buns envelop fiery gochujang-marinated tofu, igniting your senses with bold flavors and delightful contrasts.', 3.00, 'main', true);
INSERT INTO MenuItem (itemId, itemName, itemDescription, itemPrice, itemCategory, suitableForVegetarians) VALUES (nextval('ITEM_ID_SEQ'), 'Salt & Pepper Tofu', 'Soft buns, crispy seasoned tofu—a tantalizing dance of bold flavors and satisfying crunch for a memorable culinary experience.', 3.00, 'main', true);

--Dessert Menu:
INSERT INTO MenuItem (itemId, itemName, itemDescription, itemPrice, itemCategory, suitableForVegetarians) VALUES (nextval('ITEM_ID_SEQ'), 'Mango & Coconut', 'Delight in delicate layers of ripe mango and refreshing coconut, a harmonious fusion that captures the essence of summer sweetness.', 3.00, 'dessert', true);
INSERT INTO MenuItem (itemId, itemName, itemDescription, itemPrice, itemCategory, suitableForVegetarians) VALUES (nextval('ITEM_ID_SEQ'), 'Chocolate Hazelnut', 'Experience the perfect balance of creamy chocolate and nutty hazelnut, a delightful treat that enchants the palate with each bite.', 3.00, 'dessert', true);

--Sides:
INSERT INTO MenuItem (itemId, itemName, itemDescription, itemPrice, itemCategory, suitableForVegetarians) VALUES (nextval('ITEM_ID_SEQ'), 'Baked Sweet Potato', 'Savour perfectly baked sweet potato with Comté cheese and chilli-herb seasoning, a delightful blend of creamy, cheesy, and zesty goodness', 2.70, 'side', true);
INSERT INTO MenuItem (itemId, itemName, itemDescription, itemPrice, itemCategory, suitableForVegetarians) VALUES (nextval('ITEM_ID_SEQ'), 'Kimchi', 'Have a memorable meal by adding some homemade kimchi as a side.', 1.50, 'side', true);
INSERT INTO MenuItem (itemId, itemName, itemDescription, itemPrice, itemCategory, suitableForVegetarians) VALUES (nextval('ITEM_ID_SEQ'), 'Sichuan Chilli Oil', 'Crafted to perfection, there is no question about pairing freshly steamed bao with some homemade Sichuan chilli oil.', 1.00, 'side', true);

--Drinks:
INSERT INTO MenuItem (itemId, itemName, itemDescription, itemPrice, itemCategory, suitableForVegetarians) VALUES (nextval('ITEM_ID_SEQ'), 'Oat Masala Chai', 'Comfort with every sip, have a cup of masala chai Made with a harmonious blend of rich spices and creamy oats.', 2.80, 'drink', true);
INSERT INTO MenuItem (itemId, itemName, itemDescription, itemPrice, itemCategory, suitableForVegetarians) VALUES (nextval('ITEM_ID_SEQ'), 'Iced Hibiscus Tea', 'Cool down with the refreshing allure of iced hibiscus tea, a vibrant symphony of floral tanginess in every sip.', 2.20, 'drink', true);