INSERT INTO price_qualities (id, name)
VALUES (1, 'Q0'),
       (2, 'Q1a'),
       (3, 'Q1b'),
       (4, 'Q2'),
       (5, 'Q3'),
       (6, 'Q4'),
       (7, 'Q5'),
       (8, 'Q6a'),
       (9, 'Q6b')
ON CONFLICT (id) DO NOTHING;
