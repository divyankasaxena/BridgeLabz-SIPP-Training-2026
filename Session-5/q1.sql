CREATE VIEW LatestCovidData AS
SELECT c.country,
       c.date,
       c.confirmed,
       c.deaths,
       c.recovered
FROM covid_cases c
JOIN (
    SELECT country, MAX(date) AS latest_date
    FROM covid_cases
    GROUP BY country
) t
ON c.country = t.country
AND c.date = t.latest_date;
