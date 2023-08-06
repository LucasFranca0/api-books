-- Registros para livros (Book)
INSERT INTO product (title, author, publication_year, price, isbn, genre, language, product_type)
VALUES
    ('Dom Quixote', 'Miguel de Cervantes', 1605, 49.99, '978-1-234567-89-0', 'Fiction', 'Portuguese', 'book'),
    ('A Metamorfose', 'Franz Kafka', 1915, 29.99, '978-1-234567-89-1', 'Fiction', 'German', 'book'),
    ('O Senhor dos Anéis: A Sociedade do Anel', 'J.R.R. Tolkien', 1954, 59.99, '978-1-234567-89-2', 'Fantasy', 'English', 'book')
-- Adicione mais registros de livros aqui
;

-- Registros para mangás (Manga)
INSERT INTO product (title, author, publication_year, price, isbn, genre, language, product_type, volume)
VALUES
    ('One Piece Vol. 1', 'Eiichiro Oda', 1997, 12.99, '978-1-234567-90-0', 'Manga', 'Japanese', 'manga', 1),
    ('Naruto Vol. 1', 'Masashi Kishimoto', 1999, 9.99, '978-1-234567-90-1', 'Manga', 'Japanese', 'manga', 1),
    ('Berserk Vol. 1', 'Kentaro Miura', 1990, 14.99, '978-1-234567-90-2', 'Manga', 'Japanese', 'manga', 1)
-- Adicione mais registros de mangás aqui
;
