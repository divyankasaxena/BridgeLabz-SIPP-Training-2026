DELIMITER $$

CREATE FUNCTION CalculateMortalityRate(
    p_country VARCHAR(100),
    p_date DATE
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE rate DECIMAL(10,2);

    SELECT (deaths / confirmed) * 100
    INTO rate
    FROM covid_cases
    WHERE country = p_country
      AND date = p_date;

    RETURN rate;
END$$

DELIMITER ;
