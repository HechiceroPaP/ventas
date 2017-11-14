SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: ventas
--
CREATE DATABASE IF NOT EXISTS ventas DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE ventas;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla available_products_customer
--

CREATE TABLE available_products_customer (
  available_products_customer_id int(11) NOT NULL,
  product_id int(11) NOT NULL,
  customer_id int(11) NOT NULL,
  start_date date NOT NULL,
  end_date date DEFAULT NULL,
  active varchar(1) COLLATE latin1_spanish_ci NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla available_products_customer
--

INSERT INTO available_products_customer (available_products_customer_id, product_id, customer_id, start_date, end_date, active) VALUES
(1, 1, 1, '2017-11-11', NULL, 'N'),
(2, 2, 1, '2017-11-11', NULL, 'N'),
(3, 3, 1, '2017-11-11', NULL, 'N'),
(4, 4, 1, '2017-11-11', NULL, 'N'),
(5, 5, 1, '2017-11-11', NULL, 'N'),
(6, 6, 1, '2017-11-11', NULL, 'N');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla customer
--

CREATE TABLE customer (
  customer_id int(11) NOT NULL,
  name varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  email varchar(255) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla customer
--

INSERT INTO customer (customer_id, name, email) VALUES
(1, 'PABLO PEREZ', 'ingsispablo@gmail.com'),
(2, 'ANGELA CALDERON', 'ANGELA.CALDERON@GMAIL.COM'),
(3, 'PEPITO PEREZ', 'PEPITO.PEREZ@GMAIL.COM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla orders
--

CREATE TABLE orders (
  order_id int(11) NOT NULL,
  customer_id int(11) DEFAULT NULL,
  delivery_address varchar(256) COLLATE latin1_spanish_ci DEFAULT NULL,
  creation_date date NOT NULL,
  total double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla order_detail
--

CREATE TABLE order_detail (
  order_detail_id int(11) NOT NULL,
  order_id int(11) NOT NULL,
  price_id int(11) NOT NULL,
  quantity int(11) NOT NULL,
  total_value double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla price
--

CREATE TABLE price (
  price_id int(11) NOT NULL,
  product_id int(11) NOT NULL,
  value double NOT NULL,
  start_date date NOT NULL,
  end_date date DEFAULT NULL,
  active varchar(1) COLLATE latin1_spanish_ci NOT NULL DEFAULT 'S'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla price
--

INSERT INTO price (price_id, product_id, value, start_date, end_date, active) VALUES
(1, 3, 50000, '2017-11-10', '2017-11-30', 'S'),
(2, 1, 20000, '2017-11-10', '2017-11-10', 'S'),
(3, 2, 30000, '2017-11-10', '2017-11-10', 'S'),
(4, 4, 10000, '2017-11-10', '2017-11-10', 'S'),
(5, 5, 2500, '2017-11-11', NULL, 'S'),
(6, 6, 2000, '2017-11-11', NULL, 'S');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla product
--

CREATE TABLE product (
  product_id int(11) NOT NULL,
  name varchar(255) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla product
--

INSERT INTO product (product_id, name) VALUES
(1, 'HUEVOS'),
(2, 'PAPAS'),
(3, 'ARROZ'),
(4, 'TOMATES'),
(5, 'NARANJAS'),
(6, 'LIMONES');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla available_products_customer
--
ALTER TABLE available_products_customer
  ADD PRIMARY KEY (available_products_customer_id),
  ADD KEY fk_product_available (product_id),
  ADD KEY fk_customer_available_product (customer_id);

--
-- Indices de la tabla customer
--
ALTER TABLE customer
  ADD PRIMARY KEY (customer_id);

--
-- Indices de la tabla orders
--
ALTER TABLE orders
  ADD PRIMARY KEY (order_id),
  ADD KEY fk_orders_customer (customer_id) USING BTREE;

--
-- Indices de la tabla order_detail
--
ALTER TABLE order_detail
  ADD PRIMARY KEY (order_detail_id),
  ADD KEY fk_order_detail_order (order_id),
  ADD KEY fk_order_detail_price (price_id);

--
-- Indices de la tabla price
--
ALTER TABLE price
  ADD PRIMARY KEY (price_id) USING BTREE,
  ADD KEY fk_product_price (product_id) USING BTREE;

--
-- Indices de la tabla product
--
ALTER TABLE product
  ADD PRIMARY KEY (product_id);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla available_products_customer
--
ALTER TABLE available_products_customer
  MODIFY available_products_customer_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla customer
--
ALTER TABLE customer
  MODIFY customer_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla orders
--
ALTER TABLE orders
  MODIFY order_id int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla order_detail
--
ALTER TABLE order_detail
  MODIFY order_detail_id int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla price
--
ALTER TABLE price
  MODIFY price_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla product
--
ALTER TABLE product
  MODIFY product_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla available_products_customer
--
ALTER TABLE available_products_customer
  ADD CONSTRAINT available_products_customer_ibfk_1 FOREIGN KEY (product_id) REFERENCES product (product_id),
  ADD CONSTRAINT available_products_customer_ibfk_2 FOREIGN KEY (customer_id) REFERENCES customer (customer_id);

--
-- Filtros para la tabla orders
--
ALTER TABLE orders
  ADD CONSTRAINT orders_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id);

--
-- Filtros para la tabla order_detail
--
ALTER TABLE order_detail
  ADD CONSTRAINT order_detail_ibfk_1 FOREIGN KEY (price_id) REFERENCES price (price_id),
  ADD CONSTRAINT order_detail_ibfk_2 FOREIGN KEY (order_id) REFERENCES orders (order_id);

--
-- Filtros para la tabla price
--
ALTER TABLE price
  ADD CONSTRAINT price_ibfk_1 FOREIGN KEY (product_id) REFERENCES product (product_id);
COMMIT;
