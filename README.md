# Price Checker API

## 📖 Descripción del Proyecto

Este proyecto es un servicio REST desarrollado en **Spring Boot** que permite consultar el precio de un producto en una tienda determinada en función de una fecha dada. Utiliza una base de datos en memoria **H2** y está diseñado para responder a las siguientes consultas:

- Fecha de aplicación del precio
- Identificador del producto
- Identificador de la cadena de tiendas

El servicio devuelve:
- Identificador del producto
- Identificador de la cadena
- Tarifa aplicada
- Fechas de aplicación del precio
- Precio final aplicado


## 🚀 Instalación y Ejecución

### Clonar el repositorio
```sh
 git clone https://github.com/mariomartv/pricechecker.git
 cd pricechecker
```



La API estará disponible en: `http://localhost:8080/api/prices`.

## 🌐 Uso de la API

### **Endpoint principal**
```http
GET /api/prices?brandId={brandId}&productId={productId}&date={date}
```

#### **Parámetros**
| Parámetro   | Tipo     | Descripción |
|------------|---------|-------------|
| `brandId`  | Integer | Identificador de la cadena (1 = ZARA) |
| `productId`| Integer | Identificador del producto |
| `date`     | String  | Fecha en formato `yyyy-MM-dd'T'HH:mm:ss` |

#### **Ejemplo de petición**
```sh
curl -X GET "http://localhost:8080/api/prices?brandId=1&productId=35455&date=2020-06-14T16:00:00"
```

#### **Ejemplo de respuesta**
```json
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 2,
    "startDate": "2020-06-14T15:00:00",
    "endDate": "2020-06-14T18:30:00",
    "price": 25.45
}
```

## 🗄 Base de Datos (H2)

El sistema usa **H2 Database** en memoria con datos precargados.

Para acceder a la consola H2:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuario: `sa`
- Contraseña: (vacía)

## 🧪 Ejecución de Tests

Para ejecutar las pruebas unitarias y de integración:
```sh
mvn test
```

Se validan las siguientes consultas:
- `2020-06-14T10:00:00` para producto `35455` y marca `1`.
- `2020-06-14T16:00:00` para producto `35455` y marca `1`.
- `2020-06-14T21:00:00` para producto `35455` y marca `1`.
- `2020-06-15T10:00:00` para producto `35455` y marca `1`.
- `2020-06-16T21:00:00` para producto `35455` y marca `1`.


---
**Autor:** Mario Martínez Vilariño

