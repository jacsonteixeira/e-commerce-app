-- Inserting 10 new products into the product table with correct category_ids
INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
  (nextval('product_seq'), 'Bluetooth wireless headphones with noise-cancellation', 'Wireless Headphones', 200, 129.99, 50),  -- Electronics
  (nextval('product_seq'), '4K ultra HD television, 55 inches', '4K TV', 75, 899.99, 50),                                      -- Electronics
  (nextval('product_seq'), 'LED light strips for home decor', 'LED Light Strips', 120, 39.99, 50),                             -- Electronics
  (nextval('product_seq'), 'Queen-sized memory foam mattress', 'Memory Foam Mattress', 40, 499.99, 100),                      -- Furniture
  (nextval('product_seq'), 'Modern sectional sofa with cushions', 'Sectional Sofa', 60, 899.99, 100),                          -- Furniture
  (nextval('product_seq'), 'Stylish coffee table with glass top', 'Coffee Table', 80, 199.99, 100),                             -- Furniture
  (nextval('product_seq'), 'Cotton t-shirt with printed design', 'Printed T-shirt', 300, 19.99, 150),                          -- Fashion
  (nextval('product_seq'), 'High-quality leather boots for women', 'Womens Leather Boots', 150, 89.99, 150),                -- Fashion
  (nextval('product_seq'), 'Perfume set with floral and woody scents', 'Luxury Perfume Set', 200, 99.99, 200),                -- Beauty
  (nextval('product_seq'), 'Organic skincare routine set for men', 'Mens Skincare Set', 250, 79.99, 200);                   -- Beauty
