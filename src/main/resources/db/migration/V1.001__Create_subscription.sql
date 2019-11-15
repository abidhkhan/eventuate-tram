CREATE TABLE IF NOT EXISTS subscriptions (
  id                      BIGINT NOT NULL AUTO_INCREMENT,
  uuid                    VARCHAR(36) DEFAULT NULL,
  external_id              VARCHAR(36) DEFAULT NULL,
  tenant                  VARCHAR(36) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE INDEX subscriptions_id ON subscriptions (id);
