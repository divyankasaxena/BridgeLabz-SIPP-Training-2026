DELIMITER $$

CREATE FUNCTION CalculateRecoveryRate(
    p_country VARCHAR(100)
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE rate DECIMAL(10,2);

    SELECT (recovered / confirmed) * 100
    INTO rate
    FROM covid_cases
    WHERE country = p_country
    ORDER BY date DESC
    LIMIT 1;

    RETURN rate;
END$$

DELIMITER ;
