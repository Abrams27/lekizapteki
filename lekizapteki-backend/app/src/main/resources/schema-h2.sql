CREATE TABLE DISEASE (
    id                   IDENTITY            NOT NULL,
    name                 TEXT                NOT NULL,

    CONSTRAINT disease_pk PRIMARY KEY (id)
);

CREATE TABLE INGREDIENT (
     id                  IDENTITY            NOT NULL,
     name                TEXT                NOT NULL,

     CONSTRAINT ingredient_pky PRIMARY KEY (id)
);

CREATE TABLE DOSE (
     id                  IDENTITY            NOT NULL,
     dose                TEXT                NOT NULL,

     CONSTRAINT dose_pk PRIMARY KEY (id)
);

CREATE TABLE FORM (
     id                  IDENTITY            NOT NULL,
     name                TEXT                NOT NULL,

     CONSTRAINT form_pk PRIMARY KEY (id)
);

CREATE TABLE PACKAGE (
     id                  IDENTITY            NOT NULL,
     content             TEXT                NOT NULL,

     CONSTRAINT package_pk PRIMARY KEY (id)
);

CREATE TABLE PRICING (
     id                  IDENTITY            NOT NULL,

     tradePrice          DECIMAL             NOT NULL,
     salePrice           DECIMAL             NOT NULL,
     retailPrice         DECIMAL             NOT NULL,
     totalFunding        DECIMAL             NOT NULL,
     chargeFactor        DECIMAL             NOT NULL,
     refund              DECIMAL             NOT NULL,

     CONSTRAINT pricing_pk PRIMARY KEY (id)
);

CREATE TABLE MEDICINE (
      id                 IDENTITY            NOT NULL,
      ean                TEXT                NOT NULL,
      name               TEXT                NOT NULL,
      dose_id            NUMBER              NOT NULL,
      form_id            NUMBER              NOT NULL,
      pricing_id         NUMBER              NOT NULL,
      package_id         NUMBER              NOT NULL,
      ingredient_id      NUMBER              NOT NULL,
      disease_id         NUMBER              NOT NULL,

      FOREIGN KEY (dose_id) REFERENCES DOSE (id),
      FOREIGN KEY (form_id) REFERENCES FORM (id),
      FOREIGN KEY (pricing_id) REFERENCES PRICING (id),
      FOREIGN KEY (package_id) REFERENCES PACKAGE (id),
      FOREIGN KEY (ingredient_id) REFERENCES INGREDIENT (id),
      FOREIGN KEY (disease_id) REFERENCES DISEASE (id),

      CONSTRAINT medicine_pk PRIMARY KEY (id)
);
