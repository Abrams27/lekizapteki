CREATE TABLE DISEASE (
    id                  NUMERIC             NOT NULL,
    name                TEXT                NOT NULL,

    CONSTRAINT disease_pk PRIMARY KEY (id)
);

CREATE TABLE INGREDIENT (
     id                  NUMERIC             NOT NULL,
     name                TEXT                NOT NULL,

     CONSTRAINT ingredient_pky PRIMARY KEY (id)
);

CREATE TABLE DOSE (
     id                  NUMERIC             NOT NULL,
     dose                TEXT                NOT NULL,

     CONSTRAINT dose_pk PRIMARY KEY (id)
);

CREATE TABLE FORM (
     id                  NUMERIC             NOT NULL,
     name                TEXT                NOT NULL,

     CONSTRAINT form_pk PRIMARY KEY (id)
);

CREATE TABLE PACKAGE (
     id                  NUMERIC             NOT NULL,
     content             TEXT                NOT NULL,

     CONSTRAINT package_pk PRIMARY KEY (id)
);

CREATE TABLE PRICING (
     id                  NUMERIC             NOT NULL,
     salePrice           NUMERIC             NOT NULL,
     retailPrice         NUMERIC             NOT NULL,
     totalFunding        NUMERIC             NOT NULL,
     chargeFactor        NUMERIC             NOT NULL,
     refund              NUMERIC             NOT NULL,

     CONSTRAINT pricing_pk PRIMARY KEY (id)
);

CREATE TABLE MEDICINE (
      id                  NUMERIC             NOT NULL,
      ean                 TEXT                NOT NULL,
      name                TEXT                NOT NULL,
      dose_id             NUMERIC             REFERENCES DOSE (id),
      form_id             NUMERIC             REFERENCES FORM (id),
      pricing_id          NUMERIC             REFERENCES PRICING (id),
      package_id          NUMERIC             REFERENCES PACKAGE (id),
      ingredient_id       NUMERIC             REFERENCES INGREDIENT (id),
      disease_id          NUMERIC             REFERENCES DISEASE (id),

      CONSTRAINT medicine_pk PRIMARY KEY (id)
);