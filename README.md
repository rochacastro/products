# Welcome to Storage!
This project aims to carry out interactions with products. It is possible to register, change, delete and search for products

# APIs

All apis are configured to upload locally.

**API to register a product**

To register products, it is necessary to send the following request to the url: http://localhost:8080/products
with de body:

```javaasp
{
"name": "Coca",
"description": "Refrigerante",
"price": 3.0 
}
```

The curl of the request:
```javaasp
curl --location --request POST 'http://localhost:8080/products' \
--header 'Content-Type: application/json' \
--data-raw '  {
    "name": "Coca",
    "description": "Refrigerante",
    "price": 3.0 
  }'
```


- name is the name of the product.
- description is the description of the product.
- price is the price of the product.

To find a product by id it is necessary to make the following request:
```javaasp
curl --location --request GET 'http://localhost:8080/products/?id=1'
```

To find all products is necessary to make the following request:
```javaasp
curl --location --request GET 'http://localhost:8080/products'
```

To find products with a value in the name or description that contains a certain text and is between values, it is necessary to make the following request:
```javaasp
curl --location --request GET 'http://localhost:8080/products/search?q=coc&minValue=3&maxValue=10'
```

To delete a product is necessary to make the following request:
```javaasp
curl --location --request DELETE 'http://localhost:8080/products?id=3' \
--header 'Content-Type: application/json' \
--data-raw '  {
    "name": "Teste",
    "description": "Refrigerante",
    "price": 3.0 
  }'
```

To alter a product is necessary to make the following request:
```javaasp
curl --location --request PUT 'http://localhost:8080/products?id=1' \
--header 'Content-Type: application/json' \
--data-raw '  {    
    "name": "Coca",
    "description": "Refrigerante",
    "price": 3.0 
  }'
```