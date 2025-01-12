-- Inserting data into the category table
INSERT INTO category (id, description, name)
VALUES
  (nextval('category_seq'), 'Electronics items including gadgets and devices', 'Electronics'),
  (nextval('category_seq'), 'Furniture and home decor products', 'Furniture'),
  (nextval('category_seq'), 'Clothing, accessories, and shoes', 'Fashion'),
  (nextval('category_seq'), 'Health and beauty products', 'Beauty');

