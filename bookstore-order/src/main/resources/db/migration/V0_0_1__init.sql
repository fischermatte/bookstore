CREATE TABLE domain_event (
  id                  BINARY(255) NOT NULL,
  event_type          VARCHAR(50) NOT NULL,
  published_to_remote BOOLEAN     NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE "order" (
  id          BINARY(255)  NOT NULL,
  customer_id VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE order_item (
  id BINARY(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE order_submitted_event (
  customer_id VARCHAR(255) NOT NULL,
  order_id    BINARY(255)  NOT NULL,
  id          BINARY(255)  NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE order_submitted_event
  ADD CONSTRAINT FK2eh9ykov815cfw5qjgb27wycx FOREIGN KEY (id) REFERENCES domain_event;
