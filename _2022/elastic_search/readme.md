#### Original source https://github.com/rivinduchamath/ElasticSearch


https://www.elastic.co/downloads/elasticsearch
bin/elasticsearch
default port http://localhost:9200/

localhost:8080/createOrUpdateDocument
* {
* "id":"BOOK-1",
* "name":"ElasticSearchBook",
* "description":"wonderful book",
* "price":100.99
* 
* }

localhost:8080/deleteDocument?productId=BOOK-2

localhost:9200/products
localhost:9200/products/_search?pretty=true
localhost:9200/products/_doc/BOOK-22
localhost:8080/searchDocument
localhost:8080/getDocument?productId=asas
http://localhost:9200/products/_search?pretty=true&q=*BOOK*&size=2