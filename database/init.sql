-- -- Tạo cơ sở dữ liệu
-- CREATE DATABASE LibraryManagement;


CREATE TABLE employee(
	empId CHAR(16) DEFAULT substr(md5(random()::text), 1, 16) PRIMARY KEY,
	empName VARCHAR(255) NOT NULL, 
	dob DATE,
	phoneNumber char(11) NOT NULL UNIQUE,
	pwd VARCHAR(255) NOT NULL,
	gender VARCHAR(10),
	isBlock boolean DEFAULT FALSE
);

CREATE TABLE customer(
	customerId CHAR(16) DEFAULT substr(md5(random()::text), 1, 16) PRIMARY KEY,
	customerName VARCHAR(255) NOT NULL, 
	dob DATE,
	phoneNumber char(11) UNIQUE,
	pwd VARCHAR(255),
	gender VARCHAR(10),
	isBlock boolean DEFAULT FALSE,
	isMember BOOLEAN DEFAULT FALSE
);

CREATE TABLE author (
	authorId CHAR(16) DEFAULT substr(md5(random()::text), 1, 16) PRIMARY KEY,
	authorName varchar(255) NOT NULL,
	gender VARCHAR(10),
	isHide BOOLEAN DEFAULT FALSE
);

CREATE TABLE category(
	genreId CHAR(3) DEFAULT substr(md5(random()::text), 1, 3) PRIMARY KEY,
	genre varchar(64) NOT NULL
);

CREATE TABLE publisher(
	publisherId CHAR(9) DEFAULT substr(md5(random()::text), 1, 9) PRIMARY KEY,
	publisherName varchar(64) NOT NULL,
	publisherAddress varchar(255),
	isHide BOOLEAN DEFAULT FALSE
);

CREATE TABLE sheet(
	sheetId CHAR(14) DEFAULT substr(md5(random()::text), 1, 14) PRIMARY KEY,
	responsible CHAR(16) NOT NULL,
	importDate DATE NOT NULL,
	totalCost FLOAT DEFAULT 0
);

CREATE TABLE sheet_detail(
	sheetId CHAR(14),
	bookId CHAR(14),
	quantity float,
	importPrice FLOAT NOT NULL,
	PRIMARY KEY (sheetId, bookId)
);

CREATE TABLE book(
	bookId CHAR(14) DEFAULT substr(md5(random()::text), 1, 14) PRIMARY KEY,
	publisherId CHAR(9) NOT NULL,
	title VARCHAR(128) NOT NULL,
	salePrice FLOAT DEFAULT 0,
	isHide BOOLEAN DEFAULT FALSE
);

CREATE TABLE author_book(
	authorId CHAR(16),
	bookId CHAR(16),
	PRIMARY KEY (authorId, bookId)
);

CREATE TABLE book_category(
	genreId CHAR(3),
	bookId CHAR(16),
	PRIMARY KEY (genreId, bookId)
);

CREATE TABLE invoice(
	invoiceId CHAR(15) DEFAULT substr(md5(random()::text), 1, 15) PRIMARY KEY,
	customerId CHAR(16) NOT NULL,
	saleDate Date NOT NULL,
	total FLOAT DEFAULT 0
);

CREATE TABLE invoice_detail(
	invoiceId CHAR(15),
	bookId CHAR(14),
	quantity INT,
	amount FLOAT,
	PRIMARY KEY (invoiceId, bookId)
);

ALTER TABLE sheet ADD CONSTRAINT sheet_emp FOREIGN KEY (responsible) REFERENCES employee(empId);
ALTER TABLE sheet_detail ADD CONSTRAINT sheetDetail_sheet FOREIGN KEY (sheetId) REFERENCES sheet(sheetId);
ALTER TABLE sheet_detail ADD CONSTRAINT sheetDetail_book FOREIGN KEY (bookId) REFERENCES book(bookId);
ALTER TABLE book ADD CONSTRAINT book_publisher FOREIGN KEY (publisherId) REFERENCES publisher(publisherId);
ALTER TABLE author_book ADD CONSTRAINT authorBook_book FOREIGN KEY (bookId) REFERENCES book(bookId);
ALTER TABLE author_book ADD CONSTRAINT authorBook_author FOREIGN KEY (authorId) REFERENCES author(authorId);
ALTER TABLE book_category ADD CONSTRAINT authorBook_book FOREIGN KEY (bookId) REFERENCES book(bookId);
ALTER TABLE book_category ADD CONSTRAINT bookCategory_book FOREIGN KEY (bookId) REFERENCES book(bookId);
ALTER TABLE book_category ADD CONSTRAINT bookCategory_category FOREIGN KEY (genreId) REFERENCES category(genreId);
ALTER TABLE invoice ADD CONSTRAINT invoice_customer FOREIGN KEY (customerId) REFERENCES customer(customerId);
ALTER TABLE invoice_detail ADD CONSTRAINT invoiceDetail_invoice FOREIGN KEY (invoiceId) REFERENCES invoice(invoiceId);
ALTER TABLE invoice_detail ADD CONSTRAINT invoiceDetail_book FOREIGN KEY (bookId) REFERENCES book(bookId);

ALTER TABLE employee ADD CONSTRAINT CHECK_GENRE_1 CHECK(gender IN ('male', 'female'));
ALTER TABLE customer ADD CONSTRAINT CHECK_GENRE_2 CHECK(gender IN ('male', 'female'));
ALTER TABLE author ADD CONSTRAINT CHECK_GENRE_3 CHECK(gender IN ('male', 'female'));

ALTER TABLE employee ADD CONSTRAINT CHECK_AGE_1 CHECK(DOB < CURRENT_DATE);
ALTER TABLE customer ADD CONSTRAINT CHECK_AGE_2 CHECK(DOB < CURRENT_DATE);

ALTER TABLE employee ADD CONSTRAINT CHECK_PWD_1 CHECK(LENGTH(PWD) > 6);
ALTER TABLE customer ADD CONSTRAINT CHECK_PWD_2 CHECK(LENGTH(PWD) > 6);

ALTER TABLE sheet ADD CONSTRAINT CHECK_DATE_2 CHECK(importDate <= CURRENT_DATE);

ALTER TABLE INVOICE ADD CONSTRAINT CHECK_DATE_1 CHECK(saleDate <= CURRENT_DATE);
ALTER TABLE invoice_detail ADD CONSTRAINT CHECK_quantity_IN_invoiceDetail CHECK(quantity > 0);
ALTER TABLE sheet_detail ADD CONSTRAINT CHECK_quantity_IN_book CHECK(quantity >= 0);
ALTER TABLE sheet_detail ADD CONSTRAINT CHECK_importPrice_IN_book CHECK(importPrice >= 0);
ALTER TABLE sheet ADD CONSTRAINT CHECK_totalCost_IN_book CHECK(totalCost >= 0);


--Trigger
CREATE OR REPLACE FUNCTION trg_book_sold()
RETURNS TRIGGER AS $$
DECLARE
    book_id CHAR(14);
	sheet_id CHAR(14);
    book_quantity INT;
BEGIN
    FOR book_id, book_quantity IN SELECT NEW.bookId, NEW.quantity
    LOOP
		SELECT sd.sheetId INTO sheet_id 
		FROM sheet_detail sd
		JOIN sheet s on s.sheetId = sd.sheetId
		WHERE sd.bookId = book_id and book_quantity <= sd.quantity
		ORDER BY importDate DESC
        LIMIT 1; 

        UPDATE sheet_detail 
		SET quantity = quantity - book_quantity
		WHERE book_id = book_id and sheetId = sheet_id;

    END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_book_sold
AFTER INSERT ON invoice_detail
FOR EACH ROW
EXECUTE FUNCTION trg_book_sold();


CREATE OR REPLACE FUNCTION trg_book_return()
RETURNS TRIGGER AS $$
DECLARE
    book_id CHAR(14);
	sheet_id CHAR(14);
    book_quantity INT;
BEGIN
    FOR book_id, book_quantity IN SELECT OLD.bookId, OLD.quantity
    LOOP
		SELECT sd.sheetId INTO sheet_id 
		FROM sheet_detail sd
		JOIN sheet s on s.sheetId = sd.sheetId
		WHERE book_id = book_id
		ORDER BY importDate DESC
        LIMIT 1; 

        UPDATE sheet_detail 
		SET quantity = quantity + book_quantity
		WHERE book_id = book_id and sheetId = sheet_id;

    END LOOP;

    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_book_return
AFTER UPDATE OF quantity or DELETE ON invoice_detail
FOR EACH ROW
EXECUTE FUNCTION trg_book_return();

CREATE OR REPLACE FUNCTION trg_sheet_totalCost()
RETURNS TRIGGER AS $$
DECLARE
    sheetId CHAR(15);
BEGIN
    FOR sheetId IN SELECT NEW.sheetId
    LOOP
        UPDATE sheet
        SET totalCost = ROUND(CAST(COALESCE((
            SELECT SUM(quantity * importPrice)
            FROM sheet_detail ind
            WHERE sheet.sheetId = ind.sheetId
        ), 0) AS numeric), 2);
    END LOOP;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_sheet_totalCost
AFTER INSERT OR UPDATE OR DELETE ON sheet_detail
FOR EACH ROW
EXECUTE FUNCTION trg_sheet_totalCost(); 


CREATE OR REPLACE FUNCTION trg_book_salePrice()
RETURNS TRIGGER AS $$
DECLARE
	book_id CHAR(14);
	new_sale_price NUMERIC;
BEGIN
    FOR book_id IN SELECT NEW.bookId
    LOOP
        SELECT sd.importPrice INTO new_sale_price
        FROM sheet_detail sd
		JOIN sheet s ON sd.sheetId = s.sheetId
        WHERE sd.bookId = NEW.bookId
        ORDER BY s.importDate DESC
        LIMIT 1;

        UPDATE book
        SET salePrice = ROUND(new_sale_price * 1.1, 2)
        WHERE bookId = book_id;
    END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_book_salePrice
AFTER INSERT ON BOOK
FOR EACH ROW
EXECUTE FUNCTION trg_book_salePrice();

CREATE OR REPLACE TRIGGER trg_book_salePrice
AFTER INSERT OR UPDATE OF importPrice ON sheet_detail
FOR EACH ROW
EXECUTE FUNCTION trg_book_salePrice();

CREATE OR REPLACE FUNCTION trg_invoiceDetail_amount()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE invoice_detail
    SET amount = ROUND(CAST((
		quantity * (
			SELECT salePrice FROM book 
			WHERE invoice_detail.bookId = book.bookId
    )) AS numeric), 2)
	WHERE invoice_detail.invoiceId = NEW.invoiceId;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_invoiceDetail_quantity
AFTER UPDATE OF quantity OR INSERT ON invoice_detail
FOR EACH ROW
EXECUTE FUNCTION trg_invoiceDetail_amount();


CREATE OR REPLACE FUNCTION trg_invoice_totalCost()
RETURNS TRIGGER AS $$
DECLARE
    invoiceId CHAR(15);
BEGIN
    FOR invoiceId IN SELECT NEW.invoiceId
    LOOP
        UPDATE invoice
        SET total = ROUND(CAST(COALESCE((
            SELECT SUM(amount)
            FROM invoice_detail ind
            WHERE invoice.invoiceId = ind.invoiceId
        ), 0) AS numeric), 2);
    END LOOP;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_invoice_totalCost
AFTER INSERT ON invoice
FOR EACH ROW
EXECUTE FUNCTION trg_invoice_totalCost(); 

CREATE OR REPLACE TRIGGER trg_invoice_totalCost
AFTER INSERT OR DELETE OR UPDATE ON invoice_detail
FOR EACH ROW
EXECUTE FUNCTION trg_invoice_totalCost();

--Sample data
CREATE OR REPLACE FUNCTION insertEmp(
    _empName VARCHAR(255),
    _dob DATE,
	_phoneNumber CHAR(11),
	_pwd VARCHAR(255),
	_gender VARCHAR(10),
	_isBlock BOOLEAN
) RETURNS void
AS $$
	BEGIN
		INSERT INTO employee(empName, dob, phoneNumber, pwd, gender, isBlock)
		VALUES(_empName, _dob, _phoneNumber, _pwd, _gender, _isBlock);
	END;
$$ LANGUAGE plpgsql;



CREATE OR REPLACE FUNCTION insertCustomer(
    p_customerName VARCHAR(255),
    p_dob DATE,
	p_phoneNumber CHAR(11),
	p_pwd VARCHAR(255),
	p_gender VARCHAR(10),
	p_isBlock BOOLEAN,
	p_isMember BOOLEAN
) RETURNS void
AS $$
	BEGIN
		INSERT INTO customer(customerName, dob, phoneNumber, pwd, gender, isBlock, isMember)
		VALUES(p_customerName, p_dob, p_phoneNumber, p_pwd, p_gender, p_isBlock, p_isMember);
	END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION insertAuthor(
	p_authorName VARCHAR(255),
	p_gender VARCHAR(10),
	p_isHide BOOLEAN
) RETURNS void
AS $$
BEGIN
	INSERT INTO author(authorName, gender, isHide)
	VALUES (p_authorName, p_gender, p_isHide);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insertPublisher(
	pName varchar(64),
	pAddress varchar(255),
	pIsHide BOOLEAN
) RETURNS void
AS $$
BEGIN
	INSERT INTO publisher(publisherName, publisherAddress, isHide)
	VALUES (pName, pAddress, pIsHide);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insertBook(
	_publisherId CHAR(9),
	_title VARCHAR(128),
	_isHide BOOLEAN
) RETURNS void
AS $$
BEGIN
	INSERT INTO book(
	publisherId,
	title,
	isHide)
	VALUES (
	_publisherId,
	_title,
	_isHide);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insertSheet(
	_responsible CHAR(16),
	_importDate DATE
) RETURNS void
AS $$
BEGIN
	INSERT INTO sheet(
	responsible,
	importDate)
	VALUES (
	_responsible,
	_importDate);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insertSheetDetail(
	_sheetId CHAR(14),
	_bookId CHAR(14),
	_quantity float,
	_importPrice FLOAT
) RETURNS void
AS $$
BEGIN
	INSERT INTO sheet_detail(
	sheetId,
	bookId,
	quantity,
	importPrice)
	VALUES (
	_sheetId,
	_bookId,
	_quantity,
	_importPrice);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insertCaterogy(
	_genre varchar(64)
) RETURNS void
AS $$
BEGIN
	INSERT INTO category(genre)
	VALUES (_genre);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insertBookCategory(
	_genreId CHAR(3),
	_bookId CHAR(16)
) RETURNS void
AS $$
BEGIN
	INSERT INTO book_category(genreId, bookId)
	VALUES (_genreId, _bookId);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insertAuthorBook(
	_authorId CHAR(16),
	_bookId CHAR(16)
) RETURNS void
AS $$
BEGIN
	INSERT INTO author_book(authorId, bookId)
	VALUES (_authorId, _bookId);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insertBookCategory(
	_genreId CHAR(3),
	_bookId CHAR(16)
) RETURNS void
AS $$
BEGIN
	INSERT INTO book_category(genreId, bookId)
	VALUES (_genreId, _bookId);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insertInvoice(
    _customerId CHAR(16),
    _saleDate DATE
) RETURNS CHAR(15)
AS $$
DECLARE
    NewInvoiceId CHAR(15);
BEGIN
    INSERT INTO invoice(customerId, saleDate)
    VALUES (_customerId, _saleDate)
    RETURNING invoiceId INTO NewInvoiceId;

    RETURN NewInvoiceId;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insertInvoiceDetail(
	_invoiceId CHAR(15),
	_bookId CHAR(14),
	_quantity INT
) RETURNS void
AS $$
BEGIN
	INSERT INTO invoice_detail(invoiceId, BookId, quantity)
	VALUES (_invoiceId, _bookId, _quantity);
END;
$$ LANGUAGE plpgsql;

DO $$ 
DECLARE 
BEGIN
	PERFORM insertEmp('John Doe', '1990-01-01', '12345678901', 'password123', 'male', FALSE);
	PERFORM insertEmp('Laura Taylor', '1993-08-12', '45678901234', 'laura123', 'female', FALSE);
	PERFORM insertEmp('Chris Anderson', '1998-02-28', '56789012345', 'chrisPwd', 'male', false);
	PERFORM insertEmp('Megan Harris', '1990-11-15', '67890123456', 'meganPass', 'female', true);
	PERFORM insertEmp('Ryan Turner', '1985-05-22', '78901234567', 'ryanSecure', 'male', false);
	PERFORM insertEmp('Jessica Walker', '1997-04-18', '89012345678', 'jessicaPass', 'female', true);
	PERFORM insertEmp('Alex Miller', '1986-09-03', '90123456789', 'alexSecure', 'male', false);
	PERFORM insertEmp('Samantha Wilson', '1994-12-08', '34567890123', 'samanthaPwd', 'male', true);
	PERFORM insertEmp('Brandon Davis', '1989-07-25', '23456789012', 'brandon123', 'male', false);
	PERFORM insertEmp('Catherine Smith', '1996-03-10', '87654321098', 'catherinePwd', 'male', false);
	PERFORM insertEmp('Peter Johnson', '1988-01-05', '98765432109', 'peterPass', 'male', true);


	PERFORM insertCustomer('Sophie Johnson', '1993-08-12', '45678901234', 'sophie123', 'female', false, true);
	PERFORM insertCustomer('Christopher White', '1998-02-28', '56789012345', 'chrisPwd', 'male', false, true);
	PERFORM insertCustomer('Melissa Harris', '1990-11-15', '67890123456', 'melissaPass', 'female', true, false);
	PERFORM insertCustomer('David Turner', '1985-05-22', '78901234567', 'davidSecure', 'male', false, true);
	PERFORM insertCustomer('Ella Walker', '1997-04-18', '89012345678', 'ellaPass', 'female', true, true);
	PERFORM insertCustomer('Jacob Miller', '1986-09-03', '90123456789', 'jacobSecure', 'male', false, false);
	PERFORM insertCustomer('Abigail Wilson', '1994-12-08', '34567890123', 'abigailPwd', 'male', true, true);
	PERFORM insertCustomer('Nathan Davis', '1989-07-25', '23456789012', 'nathan123', 'male', false, false);
	PERFORM insertCustomer('Madison Smith', '1996-03-10', '87654321098', 'madisonPwd', 'female', false, true);
	PERFORM insertCustomer('Caleb Johnson', '1988-01-05', '98765432109', 'calebPass', 'female', true, true);
	PERFORM insertCustomer('Hailey Brown', '1992-06-20', '67000123456', 'hailey123', 'female', false, false);


	PERFORM insertAuthor('J.K. Rowling', 'female', false);
	PERFORM insertAuthor('George R.R. Martin', 'male', true);
	PERFORM insertAuthor('Agatha Christie', 'female', false);
	PERFORM insertAuthor('Jane Austen', 'female', true);
	PERFORM insertAuthor('Stephen King', 'male', false);
	PERFORM insertAuthor('J.R.R. Tolkien', 'female', true);
	PERFORM insertAuthor('Dan Brown', 'male', false);
	PERFORM insertAuthor('Harper Lee', 'male', true);
	PERFORM insertAuthor('J.D. Salinger', 'female', false);
	PERFORM insertAuthor( 'Gabriel Garcia Marquez', 'male', true);

	PERFORM insertPublisher('XYZ Books', '123 Oak St, City', false);
	PERFORM insertPublisher('ABC Publishers', '456 Maple St, Town', true);
	PERFORM insertPublisher('Best Books Co.', '789 Cedar St, Village', true);
	PERFORM insertPublisher('Top Print', '987 Pine St, Hamlet', true);
	PERFORM insertPublisher('New Age Publishers', '654 Elm St, County', true);
	PERFORM insertPublisher('Book Haven', '321 Birch St, Borough', false);
	PERFORM insertPublisher('Sunrise Publishers', '876 Pine St, District', true);
	PERFORM insertPublisher('Golden Pages', '567 Willow St, Sector', false);
	PERFORM insertPublisher('Blue Sky Books', '432 Rose St, Territory', true);
	PERFORM insertPublisher('Silver Line Publishers', '345 Ivy St, Province', true);

	PERFORM insertCaterogy ('Fantasy');
	PERFORM insertCaterogy ('Science Fiction');
	PERFORM insertCaterogy ('Mystery');
	PERFORM insertCaterogy ('Romance');
	PERFORM insertCaterogy ('Horror');
	PERFORM insertCaterogy ('Adventure');
	PERFORM insertCaterogy ('Thriller');
	PERFORM insertCaterogy ('Classics');
	PERFORM insertCaterogy ('Dystopian');
	PERFORM insertCaterogy ('Magical Realism');
	PERFORM insertCaterogy ('Historical Fiction');
	PERFORM insertCaterogy ('Children\''s');
	PERFORM insertCaterogy ('Young Adult');
	PERFORM insertCaterogy ('Humor');
	PERFORM insertCaterogy ('Non-fiction');
	PERFORM insertCaterogy ('Mystery');
	PERFORM insertCaterogy ('Romantic Suspense');
	PERFORM insertCaterogy ('Philosophy');
	PERFORM insertCaterogy ('Science');
	PERFORM insertCaterogy ('Drama');
	RETURN;
END $$;

DO $$ 
DECLARE 
	publisher_id_1 CHAR(9);
    publisher_id_2 CHAR(9);
    publisher_id_3 CHAR(9);
    publisher_id_4 CHAR(9);
    publisher_id_5 CHAR(9);
BEGIN
    SELECT publisherId INTO publisher_id_1 FROM publisher WHERE publisherName = 'XYZ Books';
    SELECT publisherId INTO publisher_id_2 FROM publisher WHERE publisherName = 'ABC Publishers';
    SELECT publisherId INTO publisher_id_3 FROM publisher WHERE publisherName = 'Best Books Co.';
    SELECT publisherId INTO publisher_id_4 FROM publisher WHERE publisherName = 'Top Print';
    SELECT publisherId INTO publisher_id_5 FROM publisher WHERE publisherName = 'New Age Publishers';

	PERFORM insertBook(publisher_id_1, 'Harry Potter and the Sorcerer\''s Stone', false);
	PERFORM insertBook(publisher_id_2, 'A Game of Thrones', true);
	PERFORM insertBook(publisher_id_3, 'Murder on the Orient Express', false);
	PERFORM insertBook(publisher_id_4, 'Pride and Prejudice', true);
	PERFORM insertBook(publisher_id_5, 'The Shining', false);
	PERFORM insertBook(publisher_id_1, 'The Hobbit', false);
	PERFORM insertBook(publisher_id_2, 'The Da Vinci Code', true);
	PERFORM insertBook(publisher_id_3, 'To Kill a Mockingbird', false);
	PERFORM insertBook(publisher_id_4, 'The Catcher in the Rye', false);
	PERFORM insertBook(publisher_id_5, 'One Hundred Years of Solitude', true);
	PERFORM insertBook(publisher_id_1, 'The Old Man and the Sea', false);
	PERFORM insertBook(publisher_id_2, 'The Handmaid\''s Tale', true);
	PERFORM insertBook(publisher_id_3, 'Charlie and the Chocolate Factory', false);
	PERFORM insertBook(publisher_id_4, 'Moby-Dick', false);
	PERFORM insertBook(publisher_id_5, 'War and Peace', true);

	RETURN;
END $$;

DO $$ 
DECLARE 
    bookId_1 CHAR(14);
    bookId_2 CHAR(14);
    bookId_3 CHAR(14);
    bookId_4 CHAR(14);
    bookId_5 CHAR(14);
    bookId_6 CHAR(14);
    bookId_7 CHAR(14);
    bookId_8 CHAR(14);
    bookId_9 CHAR(14);
    bookId_10 CHAR(14);
    bookId_11 CHAR(14);
    bookId_12 CHAR(14);
    bookId_13 CHAR(14);
    bookId_14 CHAR(14);
    bookId_15 CHAR(14);

	genreId_1 CHAR(3);
    genreId_2 CHAR(3);
    genreId_3 CHAR(3);
    genreId_4 CHAR(3);
    genreId_5 CHAR(3);
    genreId_6 CHAR(3);
    genreId_7 CHAR(3);
    genreId_8 CHAR(3);
    genreId_9 CHAR(3);
    genreId_10 CHAR(3);
    genreId_11 CHAR(3);
    genreId_12 CHAR(3);
    genreId_13 CHAR(3);
    genreId_14 CHAR(3);
    genreId_15 CHAR(3);
    genreId_16 CHAR(3);
    genreId_17 CHAR(3);
    genreId_18 CHAR(3);
    genreId_19 CHAR(3);
    genreId_20 CHAR(3);
BEGIN
    SELECT bookId INTO bookId_1 FROM book WHERE title = 'Harry Potter and the Sorcerer\''s Stone';
    SELECT bookId INTO bookId_2 FROM book WHERE title = 'A Game of Thrones';
    SELECT bookId INTO bookId_3 FROM book WHERE title = 'Murder on the Orient Express';
    SELECT bookId INTO bookId_4 FROM book WHERE title = 'Pride and Prejudice';
    SELECT bookId INTO bookId_5 FROM book WHERE title = 'The Shining';
    SELECT bookId INTO bookId_6 FROM book WHERE title = 'The Hobbit';
    SELECT bookId INTO bookId_7 FROM book WHERE title = 'The Da Vinci Code';
    SELECT bookId INTO bookId_8 FROM book WHERE title = 'To Kill a Mockingbird';
    SELECT bookId INTO bookId_9 FROM book WHERE title = 'The Catcher in the Rye';
    SELECT bookId INTO bookId_10 FROM book WHERE title = 'One Hundred Years of Solitude';
    SELECT bookId INTO bookId_11 FROM book WHERE title = 'The Old Man and the Sea';
    SELECT bookId INTO bookId_12 FROM book WHERE title = 'The Handmaid\''s Tale';
    SELECT bookId INTO bookId_13 FROM book WHERE title = 'Charlie and the Chocolate Factory';
    SELECT bookId INTO bookId_14 FROM book WHERE title = 'Moby-Dick';
    SELECT bookId INTO bookId_15 FROM book WHERE title = 'War and Peace';

	SELECT genreId INTO genreId_1 FROM category WHERE genre = 'Drama';
	SELECT genreId INTO genreId_2 FROM category WHERE genre = 'Fantasy';
    SELECT genreId INTO genreId_3 FROM category WHERE genre = 'Science Fiction';
    SELECT genreId INTO genreId_4 FROM category WHERE genre = 'Mystery';
    SELECT genreId INTO genreId_5 FROM category WHERE genre = 'Romance';
    SELECT genreId INTO genreId_6 FROM category WHERE genre = 'Horror';
    SELECT genreId INTO genreId_7 FROM category WHERE genre = 'Adventure';
    SELECT genreId INTO genreId_8 FROM category WHERE genre = 'Thriller';
    SELECT genreId INTO genreId_9 FROM category WHERE genre = 'Classics';
    SELECT genreId INTO genreId_10 FROM category WHERE genre = 'Dystopian';
    SELECT genreId INTO genreId_11 FROM category WHERE genre = 'Magical Realism';
    SELECT genreId INTO genreId_12 FROM category WHERE genre = 'Historical Fiction';
    SELECT genreId INTO genreId_13 FROM category WHERE genre = 'Children\''s';
    SELECT genreId INTO genreId_14 FROM category WHERE genre = 'Young Adult';
    SELECT genreId INTO genreId_15 FROM category WHERE genre = 'Humor';
    SELECT genreId INTO genreId_16 FROM category WHERE genre = 'Non-fiction';
    SELECT genreId INTO genreId_17 FROM category WHERE genre = 'Mystery';
    SELECT genreId INTO genreId_18 FROM category WHERE genre = 'Romantic Suspense';
    SELECT genreId INTO genreId_19 FROM category WHERE genre = 'Philosophy';
    SELECT genreId INTO genreId_20 FROM category WHERE genre = 'Science';

	PERFORM insertBookCategory(genreId_1, bookId_1);
	PERFORM insertBookCategory(genreId_2, bookId_1);
	PERFORM insertBookCategory(genreId_3, bookId_1);
	PERFORM insertBookCategory(genreId_1, bookId_2);
	PERFORM insertBookCategory(genreId_3, bookId_2);
	PERFORM insertBookCategory(genreId_2, bookId_3);
	PERFORM insertBookCategory(genreId_5, bookId_4);
	PERFORM insertBookCategory(genreId_6, bookId_5);
	PERFORM insertBookCategory(genreId_7, bookId_5);
	PERFORM insertBookCategory(genreId_8, bookId_6);
	PERFORM insertBookCategory(genreId_8, bookId_7);
	PERFORM insertBookCategory(genreId_9, bookId_7);
	PERFORM insertBookCategory(genreId_10, bookId_7);
	PERFORM insertBookCategory(genreId_12, bookId_7);
	PERFORM insertBookCategory(genreId_14, bookId_8);
	PERFORM insertBookCategory(genreId_16, bookId_9);
	PERFORM insertBookCategory(genreId_17, bookId_9);
	PERFORM insertBookCategory(genreId_18, bookId_10);
	PERFORM insertBookCategory(genreId_19, bookId_11);
	PERFORM insertBookCategory(genreId_14, bookId_12);
	PERFORM insertBookCategory(genreId_15, bookId_12);
	PERFORM insertBookCategory(genreId_20, bookId_12);
	PERFORM insertBookCategory(genreId_9, bookId_13);
	PERFORM insertBookCategory(genreId_3, bookId_14);
	PERFORM insertBookCategory(genreId_8, bookId_14);
	PERFORM insertBookCategory(genreId_12, bookId_15);
	PERFORM insertBookCategory(genreId_14, bookId_15);
	PERFORM insertBookCategory(genreId_16, bookId_15);

	RETURN;
END $$;

DO $$ 
DECLARE 
    bookId_1 CHAR(14);
    bookId_2 CHAR(14);
    bookId_3 CHAR(14);
    bookId_4 CHAR(14);
    bookId_5 CHAR(14);
    bookId_6 CHAR(14);
    bookId_7 CHAR(14);
    bookId_8 CHAR(14);
    bookId_9 CHAR(14);
    bookId_10 CHAR(14);
    bookId_11 CHAR(14);
    bookId_12 CHAR(14);
    bookId_13 CHAR(14);
    bookId_14 CHAR(14);
    bookId_15 CHAR(14);

	authorId_1 CHAR(16);
    authorId_2 CHAR(16);
    authorId_3 CHAR(16);
    authorId_4 CHAR(16);
    authorId_5 CHAR(16);
    authorId_6 CHAR(16);
    authorId_7 CHAR(16);
    authorId_8 CHAR(16);
    authorId_9 CHAR(16);
    authorId_10 CHAR(16);
BEGIN
    SELECT bookId INTO bookId_1 FROM book WHERE title = 'Harry Potter and the Sorcerer\''s Stone';
    SELECT bookId INTO bookId_2 FROM book WHERE title = 'A Game of Thrones';
    SELECT bookId INTO bookId_3 FROM book WHERE title = 'Murder on the Orient Express';
    SELECT bookId INTO bookId_4 FROM book WHERE title = 'Pride and Prejudice';
    SELECT bookId INTO bookId_5 FROM book WHERE title = 'The Shining';
    SELECT bookId INTO bookId_6 FROM book WHERE title = 'The Hobbit';
    SELECT bookId INTO bookId_7 FROM book WHERE title = 'The Da Vinci Code';
    SELECT bookId INTO bookId_8 FROM book WHERE title = 'To Kill a Mockingbird';
    SELECT bookId INTO bookId_9 FROM book WHERE title = 'The Catcher in the Rye';
    SELECT bookId INTO bookId_10 FROM book WHERE title = 'One Hundred Years of Solitude';
    SELECT bookId INTO bookId_11 FROM book WHERE title = 'The Old Man and the Sea';
    SELECT bookId INTO bookId_12 FROM book WHERE title = 'The Handmaid\''s Tale';
    SELECT bookId INTO bookId_13 FROM book WHERE title = 'Charlie and the Chocolate Factory';
    SELECT bookId INTO bookId_14 FROM book WHERE title = 'Moby-Dick';
    SELECT bookId INTO bookId_15 FROM book WHERE title = 'War and Peace';

	SELECT authorId INTO authorId_1 FROM author WHERE authorName = 'J.K. Rowling';
	SELECT authorId INTO authorId_2 FROM author WHERE authorName = 'George R.R. Martin';
    SELECT authorId INTO authorId_3 FROM author WHERE authorName = 'Agatha Christie';
    SELECT authorId INTO authorId_4 FROM author WHERE authorName = 'Jane Austen';
    SELECT authorId INTO authorId_5 FROM author WHERE authorName = 'Stephen King';
    SELECT authorId INTO authorId_6 FROM author WHERE authorName = 'J.R.R. Tolkien';
    SELECT authorId INTO authorId_7 FROM author WHERE authorName = 'Dan Brown';
    SELECT authorId INTO authorId_8 FROM author WHERE authorName = 'Harper Lee';
    SELECT authorId INTO authorId_9 FROM author WHERE authorName = 'J.D. Salinger';
    SELECT authorId INTO authorId_10 FROM author WHERE authorName = 'Gabriel Garcia Marquez';
   

	PERFORM insertAuthorBook(authorId_1, bookId_1);
	PERFORM insertAuthorBook(authorId_2, bookId_1);
	PERFORM insertAuthorBook(authorId_3, bookId_1);
	PERFORM insertAuthorBook(authorId_1, bookId_2);
	PERFORM insertAuthorBook(authorId_3, bookId_2);
	PERFORM insertAuthorBook(authorId_2, bookId_3);
	PERFORM insertAuthorBook(authorId_5, bookId_4);
	PERFORM insertAuthorBook(authorId_6, bookId_5);
	PERFORM insertAuthorBook(authorId_7, bookId_5);
	PERFORM insertAuthorBook(authorId_8, bookId_6);
	PERFORM insertAuthorBook(authorId_8, bookId_7);
	PERFORM insertAuthorBook(authorId_9, bookId_7);
	PERFORM insertAuthorBook(authorId_10, bookId_7);
	PERFORM insertAuthorBook(authorId_2, bookId_7);
	PERFORM insertAuthorBook(authorId_4, bookId_8);
	PERFORM insertAuthorBook(authorId_6, bookId_9);
	PERFORM insertAuthorBook(authorId_7, bookId_9);
	PERFORM insertAuthorBook(authorId_8, bookId_10);
	PERFORM insertAuthorBook(authorId_9, bookId_11);
	PERFORM insertAuthorBook(authorId_4, bookId_12);
	PERFORM insertAuthorBook(authorId_5, bookId_12);
	PERFORM insertAuthorBook(authorId_10, bookId_12);
	PERFORM insertAuthorBook(authorId_9, bookId_13);
	PERFORM insertAuthorBook(authorId_3, bookId_14);
	PERFORM insertAuthorBook(authorId_8, bookId_14);
	PERFORM insertAuthorBook(authorId_2, bookId_15);
	PERFORM insertAuthorBook(authorId_4, bookId_15);
	PERFORM insertAuthorBook(authorId_6, bookId_15);
	RETURN;
END $$;

DO $$ 
DECLARE 
	emp_id_1 CHAR(16);
    emp_id_2 CHAR(16);
    emp_id_3 CHAR(16);
    emp_id_4 CHAR(16);
    emp_id_5 CHAR(16);
    emp_id_6 CHAR(16);
BEGIN
	SELECT empId INTO emp_id_1 FROM employee WHERE empName = 'John Doe';
    SELECT empId INTO emp_id_2 FROM employee WHERE empName = 'Chris Anderson';
    SELECT empId INTO emp_id_3 FROM employee WHERE empName = 'Catherine Smith';
    SELECT empId INTO emp_id_4 FROM employee WHERE empName = 'Ryan Turner';
    SELECT empId INTO emp_id_5 FROM employee WHERE empName = 'Alex Miller';
    SELECT empId INTO emp_id_6 FROM employee WHERE empName = 'Brandon Davis';

    PERFORM insertSheet(emp_id_2, '2023-03-05');
	PERFORM insertSheet(emp_id_3, '2023-03-10');	
	PERFORM insertSheet(emp_id_3, '2023-03-15');	
	PERFORM insertSheet(emp_id_4, '2023-03-20');
	PERFORM insertSheet(emp_id_5, '2023-03-25');
	
	RETURN;
END $$;

DO $$ 
DECLARE 
	sheetId_1 CHAR(14);
	sheetId_2 CHAR(14);
	sheetId_3 CHAR(14);
	sheetId_4 CHAR(14);
	sheetId_5 CHAR(14);
	sheetId_6 CHAR(14);
	sheetId_7 CHAR(14);
	sheetId_8 CHAR(14);
	sheetId_9 CHAR(14);

	bookId_1 CHAR(14);
    bookId_2 CHAR(14);
    bookId_3 CHAR(14);
    bookId_4 CHAR(14);
    bookId_5 CHAR(14);
    bookId_6 CHAR(14);
    bookId_7 CHAR(14);
    bookId_8 CHAR(14);
    bookId_9 CHAR(14);
    bookId_10 CHAR(14);
    bookId_11 CHAR(14);
    bookId_12 CHAR(14);
    bookId_13 CHAR(14);
    bookId_14 CHAR(14);
    bookId_15 CHAR(14);
BEGIN
	SELECT sheetId INTO sheetId_1 FROM sheet WHERE importDate = '2023-03-05';
    SELECT sheetId INTO sheetId_2 FROM sheet WHERE importDate = '2023-03-10';
    SELECT sheetId INTO sheetId_3 FROM sheet WHERE importDate = '2023-03-15';
    SELECT sheetId INTO sheetId_4 FROM sheet WHERE importDate = '2023-03-20';
    SELECT sheetId INTO sheetId_5 FROM sheet WHERE importDate = '2023-03-25';

	SELECT bookId INTO bookId_1 FROM book WHERE title = 'Harry Potter and the Sorcerer\''s Stone';
    SELECT bookId INTO bookId_2 FROM book WHERE title = 'A Game of Thrones';
    SELECT bookId INTO bookId_3 FROM book WHERE title = 'Murder on the Orient Express';
    SELECT bookId INTO bookId_4 FROM book WHERE title = 'Pride and Prejudice';
    SELECT bookId INTO bookId_5 FROM book WHERE title = 'The Shining';
    SELECT bookId INTO bookId_6 FROM book WHERE title = 'The Hobbit';
    SELECT bookId INTO bookId_7 FROM book WHERE title = 'The Da Vinci Code';
    SELECT bookId INTO bookId_8 FROM book WHERE title = 'To Kill a Mockingbird';
    SELECT bookId INTO bookId_9 FROM book WHERE title = 'The Catcher in the Rye';
    SELECT bookId INTO bookId_10 FROM book WHERE title = 'One Hundred Years of Solitude';
    SELECT bookId INTO bookId_11 FROM book WHERE title = 'The Old Man and the Sea';
    SELECT bookId INTO bookId_12 FROM book WHERE title = 'The Handmaid\''s Tale';
    SELECT bookId INTO bookId_13 FROM book WHERE title = 'Charlie and the Chocolate Factory';
    SELECT bookId INTO bookId_14 FROM book WHERE title = 'Moby-Dick';
    SELECT bookId INTO bookId_15 FROM book WHERE title = 'War and Peace';

	PERFORM insertSheetDetail(sheetId_1, bookId_1, 300, 20);
	PERFORM insertSheetDetail(sheetId_1, bookId_2, 250, 25);
	PERFORM insertSheetDetail(sheetId_1, bookId_3, 100, 15.25);
	PERFORM insertSheetDetail(sheetId_1, bookId_4, 800, 18);

	PERFORM insertSheetDetail(sheetId_2, bookId_5, 400, 30);
	PERFORM insertSheetDetail(sheetId_2, bookId_6, 210, 16);

	PERFORM insertSheetDetail(sheetId_3, bookId_7, 320, 24);
	PERFORM insertSheetDetail(sheetId_3, bookId_8, 430, 20);
	PERFORM insertSheetDetail(sheetId_3, bookId_9, 560, 28);

	PERFORM insertSheetDetail(sheetId_4, bookId_10, 800, 32);
	PERFORM insertSheetDetail(sheetId_4, bookId_11, 750, 19.50);
	PERFORM insertSheetDetail(sheetId_4, bookId_12, 1000, 18.50);

	PERFORM insertSheetDetail(sheetId_5, bookId_13, 300, 26.50);
	PERFORM insertSheetDetail(sheetId_5, bookId_14, 100, 22.50);
	PERFORM insertSheetDetail(sheetId_5, bookId_15, 50, 26);
	
	RETURN;
END $$;

DO $$ 
DECLARE 
	customerId_1 CHAR(16);
    customerId_2 CHAR(16);
    customerId_3 CHAR(16);
    customerId_4 CHAR(16);
    customerId_5 CHAR(16);
    customerId_6 CHAR(16);
    customerId_7 CHAR(16);
    customerId_8 CHAR(16);
    customerId_9 CHAR(16);
    customerId_10 CHAR(16);

	invoiceId_1 CHAR(15);
    invoiceId_2 CHAR(15);
    invoiceId_3 CHAR(15);
    invoiceId_4 CHAR(15);
    invoiceId_5 CHAR(15);
    invoiceId_6 CHAR(15);
    invoiceId_7 CHAR(15);
    invoiceId_8 CHAR(15);
    invoiceId_9 CHAR(15);
    invoiceId_10 CHAR(15);
    invoiceId_11 CHAR(15);
    invoiceId_12 CHAR(15);
    invoiceId_13 CHAR(15);
    invoiceId_14 CHAR(15);
    invoiceId_15 CHAR(15);
    invoiceId_16 CHAR(15);
    invoiceId_17 CHAR(15);
    invoiceId_18 CHAR(15);
    invoiceId_19 CHAR(15);
    invoiceId_20 CHAR(15);

	bookId_1 CHAR(14);
    bookId_2 CHAR(14);
    bookId_3 CHAR(14);
    bookId_4 CHAR(14);
    bookId_5 CHAR(14);
    bookId_6 CHAR(14);
    bookId_7 CHAR(14);
    bookId_8 CHAR(14);
    bookId_9 CHAR(14);
    bookId_10 CHAR(14);
    bookId_11 CHAR(14);
    bookId_12 CHAR(14);
    bookId_13 CHAR(14);
    bookId_14 CHAR(14);
    bookId_15 CHAR(14);
BEGIN
	SELECT bookId INTO bookId_1 FROM book WHERE title = 'Harry Potter and the Sorcerer\''s Stone';
    SELECT bookId INTO bookId_2 FROM book WHERE title = 'A Game of Thrones';
    SELECT bookId INTO bookId_3 FROM book WHERE title = 'Murder on the Orient Express';
    SELECT bookId INTO bookId_4 FROM book WHERE title = 'Pride and Prejudice';
    SELECT bookId INTO bookId_5 FROM book WHERE title = 'The Shining';
    SELECT bookId INTO bookId_6 FROM book WHERE title = 'The Hobbit';
    SELECT bookId INTO bookId_7 FROM book WHERE title = 'The Da Vinci Code';
    SELECT bookId INTO bookId_8 FROM book WHERE title = 'To Kill a Mockingbird';
    SELECT bookId INTO bookId_9 FROM book WHERE title = 'The Catcher in the Rye';
    SELECT bookId INTO bookId_10 FROM book WHERE title = 'One Hundred Years of Solitude';
    SELECT bookId INTO bookId_11 FROM book WHERE title = 'The Old Man and the Sea';
    SELECT bookId INTO bookId_12 FROM book WHERE title = 'The Handmaid\''s Tale';
    SELECT bookId INTO bookId_13 FROM book WHERE title = 'Charlie and the Chocolate Factory';
    SELECT bookId INTO bookId_14 FROM book WHERE title = 'Moby-Dick';
    SELECT bookId INTO bookId_15 FROM book WHERE title = 'War and Peace';

	SELECT customerId INTO customerId_1 FROM customer WHERE customerName = 'Sophie Johnson';
	SELECT customerId INTO customerId_2 FROM customer WHERE customerName = 'Christopher White';
    SELECT customerId INTO customerId_3 FROM customer WHERE customerName = 'Melissa Harris';
    SELECT customerId INTO customerId_4 FROM customer WHERE customerName = 'David Turner';
    SELECT customerId INTO customerId_5 FROM customer WHERE customerName = 'Ella Walker';
    SELECT customerId INTO customerId_6 FROM customer WHERE customerName = 'Jacob Miller';
    SELECT customerId INTO customerId_7 FROM customer WHERE customerName = 'Abigail Wilson';
    SELECT customerId INTO customerId_8 FROM customer WHERE customerName = 'Nathan Davis';
    SELECT customerId INTO customerId_9 FROM customer WHERE customerName = 'Madison Smith';
    SELECT customerId INTO customerId_10 FROM customer WHERE customerName = 'Caleb Johnson';
   
	SELECT insertInvoice(customerId_2, '2023-03-05') INTO invoiceId_2;
	PERFORM insertInvoiceDetail(invoiceId_2, bookId_1, 2);
	PERFORM insertInvoiceDetail(invoiceId_2, bookId_2, 1);
	PERFORM insertInvoiceDetail(invoiceId_2, bookId_3, 1);
	PERFORM insertInvoiceDetail(invoiceId_2, bookId_6, 1);
	PERFORM insertInvoiceDetail(invoiceId_2, bookId_7, 2);
	PERFORM insertInvoiceDetail(invoiceId_2, bookId_8, 1);

	SELECT insertInvoice(customerId_3, '2023-03-10') INTO invoiceId_3;
	PERFORM insertInvoiceDetail(invoiceId_3, bookId_3, 1);
	PERFORM insertInvoiceDetail(invoiceId_3, bookId_5, 1);
	PERFORM insertInvoiceDetail(invoiceId_3, bookId_6, 1);
	PERFORM insertInvoiceDetail(invoiceId_3, bookId_7, 3);
	PERFORM insertInvoiceDetail(invoiceId_3, bookId_14, 1);
	PERFORM insertInvoiceDetail(invoiceId_3, bookId_15, 1);

	SELECT insertInvoice(customerId_4, '2023-03-15') INTO invoiceId_4;
	PERFORM insertInvoiceDetail(invoiceId_4, bookId_11, 1);
	PERFORM insertInvoiceDetail(invoiceId_4, bookId_13, 1);
	
	SELECT insertInvoice(customerId_5, '2023-03-20') INTO invoiceId_5;
	PERFORM insertInvoiceDetail(invoiceId_5, bookId_1, 1);
	PERFORM insertInvoiceDetail(invoiceId_5, bookId_3, 1);
	PERFORM insertInvoiceDetail(invoiceId_5, bookId_9, 1);
	PERFORM insertInvoiceDetail(invoiceId_5, bookId_12, 3);
	PERFORM insertInvoiceDetail(invoiceId_5, bookId_13, 1);
	PERFORM insertInvoiceDetail(invoiceId_5, bookId_15, 1);

	SELECT insertInvoice(customerId_6, '2023-03-25') INTO invoiceId_6;
	PERFORM insertInvoiceDetail(invoiceId_6, bookId_3, 2);
	PERFORM insertInvoiceDetail(invoiceId_6, bookId_5, 2);
	PERFORM insertInvoiceDetail(invoiceId_6, bookId_6, 2);

	SELECT insertInvoice(customerId_7, '2023-03-30') INTO invoiceId_7;
	PERFORM insertInvoiceDetail(invoiceId_7, bookId_7, 1);
	PERFORM insertInvoiceDetail(invoiceId_7, bookId_14, 2);
	PERFORM insertInvoiceDetail(invoiceId_7, bookId_15, 3);

	SELECT insertInvoice(customerId_8, '2023-04-02') INTO invoiceId_8;
	PERFORM insertInvoiceDetail(invoiceId_8, bookId_2, 1);
	PERFORM insertInvoiceDetail(invoiceId_8, bookId_3, 2);
	PERFORM insertInvoiceDetail(invoiceId_8, bookId_4, 1);
	PERFORM insertInvoiceDetail(invoiceId_8, bookId_7, 2);
	PERFORM insertInvoiceDetail(invoiceId_8, bookId_8, 1);
	PERFORM insertInvoiceDetail(invoiceId_8, bookId_9, 3);

	SELECT insertInvoice(customerId_9, '2023-04-07') INTO invoiceId_9;
	PERFORM insertInvoiceDetail(invoiceId_9, bookId_3, 1);
	
	SELECT insertInvoice(customerId_10, '2023-04-12') INTO invoiceId_10;
	PERFORM insertInvoiceDetail(invoiceId_10, bookId_3, 1);
	PERFORM insertInvoiceDetail(invoiceId_10, bookId_15, 1);

	RETURN;
END $$;
