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

CREATE TABLE member(
	memberId CHAR(16) DEFAULT substr(md5(random()::text), 1, 16) PRIMARY KEY,
	memberName VARCHAR(255) NOT NULL, 
	dob DATE,
	phoneNumber char(11) UNIQUE,
	gender VARCHAR(10)
);

CREATE TABLE administrator(
	adminId CHAR(16) DEFAULT substr(md5(random()::text), 1, 16) PRIMARY KEY,
	adminName VARCHAR(255) NOT NULL, 
	dob DATE,
	phoneNumber char(11) UNIQUE,
	pwd VARCHAR(255),
	gender VARCHAR(10)
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
	bookEdition INT,
	publisherId CHAR(9) NOT NULL,
	title VARCHAR(128) NOT NULL,
	salePrice FLOAT DEFAULT 0,
	quantity INT DEFAULT 0,
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
	empId CHAR(16),
	memberId CHAR(16) NOT NULL,
	saleDate Date NOT NULL,
	total FLOAT DEFAULT 0
);

CREATE TABLE invoice_detail(
	invoiceId CHAR(15),
	bookId CHAR(14),
	quantity INT,
	cost FLOAT,
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
ALTER TABLE invoice ADD CONSTRAINT invoice_member FOREIGN KEY (memberId) REFERENCES member(memberId);
ALTER TABLE invoice ADD CONSTRAINT invoice_employee FOREIGN KEY (empId) REFERENCES employee(empId);
ALTER TABLE invoice_detail ADD CONSTRAINT invoiceDetail_invoice FOREIGN KEY (invoiceId) REFERENCES invoice(invoiceId);
ALTER TABLE invoice_detail ADD CONSTRAINT invoiceDetail_book FOREIGN KEY (bookId) REFERENCES book(bookId);

ALTER TABLE employee ADD CONSTRAINT CHECK_GENRE_1 CHECK(gender IN ('male', 'female'));
ALTER TABLE member ADD CONSTRAINT CHECK_GENRE_2 CHECK(gender IN ('male', 'female'));
ALTER TABLE author ADD CONSTRAINT CHECK_GENRE_3 CHECK(gender IN ('male', 'female'));
ALTER TABLE administrator ADD CONSTRAINT CHECK_GENRE_4 CHECK(gender IN ('male', 'female'));

ALTER TABLE employee ADD CONSTRAINT CHECK_AGE_1 CHECK(DOB < CURRENT_DATE);
ALTER TABLE member ADD CONSTRAINT CHECK_AGE_2 CHECK(DOB < CURRENT_DATE);
ALTER TABLE administrator ADD CONSTRAINT CHECK_AGE_3 CHECK(DOB < CURRENT_DATE);

ALTER TABLE employee ADD CONSTRAINT CHECK_PWD_1 CHECK(LENGTH(PWD) > 6);
ALTER TABLE administrator ADD CONSTRAINT CHECK_PWD_3 CHECK(LENGTH(PWD) > 6);

ALTER TABLE sheet ADD CONSTRAINT CHECK_DATE_2 CHECK(importDate <= CURRENT_DATE);

ALTER TABLE INVOICE ADD CONSTRAINT CHECK_DATE_1 CHECK(saleDate <= CURRENT_DATE);
ALTER TABLE invoice_detail ADD CONSTRAINT CHECK_quantity_IN_invoiceDetail CHECK(quantity > 0);
ALTER TABLE sheet_detail ADD CONSTRAINT CHECK_quantity_IN_book CHECK(quantity >= 0);
ALTER TABLE sheet_detail ADD CONSTRAINT CHECK_importPrice_IN_book CHECK(importPrice >= 0);
ALTER TABLE sheet ADD CONSTRAINT CHECK_totalCost_IN_book CHECK(totalCost >= 0);
ALTER TABLE book ADD CONSTRAINT CHECK_bookEdition CHECK(bookEdition >= 1);


--Trigger
CREATE OR REPLACE FUNCTION trg_after_invoiceDetail_add()
RETURNS TRIGGER AS $$
DECLARE
    book_id CHAR(14);
    book_quantity INT;
BEGIN
    FOR book_id, book_quantity IN SELECT NEW.bookId, NEW.quantity
    LOOP
		UPDATE book
		SET quantity = quantity - book_quantity
		where book_id = bookId;
    END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_after_invoiceDetail_add
AFTER INSERT ON invoice_detail
FOR EACH ROW
EXECUTE FUNCTION trg_after_invoiceDetail_add();

CREATE OR REPLACE FUNCTION trg_after_invoiceDetail_remove()
RETURNS TRIGGER AS $$
DECLARE
    book_id CHAR(14);
    book_quantity INT;
BEGIN
    FOR book_id, book_quantity IN SELECT OLD.bookId, OLD.quantity
    LOOP
		UPDATE book
		SET quantity = quantity + book_quantity
		where book_id = bookId;
    END LOOP;

    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_after_invoiceDetail_remove
AFTER DELETE ON invoice_detail
FOR EACH ROW
EXECUTE FUNCTION trg_after_invoiceDetail_remove();

CREATE OR REPLACE FUNCTION trg_after_invoiceDetail_update()
RETURNS TRIGGER AS $$
DECLARE
	invoice_id CHAR(15);
    book_id CHAR(14);
    book_quantity_old INT;
    book_quantity_new INT;
BEGIN
    FOR invoice_id, book_id, book_quantity_old, book_quantity_new IN SELECT OLD.invoiceId, OLD.bookId, OLD.quantity, NEW.quantity
    LOOP
		UPDATE book
		SET quantity = quantity + book_quantity_old - book_quantity_new
		where book_id = bookId;
    END LOOP;

    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_after_invoiceDetail_update
AFTER UPDATE OF quantity ON invoice_detail
FOR EACH ROW
EXECUTE FUNCTION trg_after_invoiceDetail_update();


CREATE OR REPLACE FUNCTION trg_after_sheetDetail_insert()
RETURNS TRIGGER AS $$
DECLARE
    sheet_id CHAR(15);
	book_id CHAR(14);
	import_price FLOAT;
	max_price FLOAT;
	amount INT;
BEGIN
    FOR sheet_id, import_price, book_id, amount IN SELECT NEW.sheetId, NEW.importPrice, NEW.bookId, NEW.quantity
    LOOP
        UPDATE sheet
        SET totalCost = ROUND(CAST(COALESCE((
            SELECT SUM(quantity * importPrice)
            FROM sheet_detail ind
            WHERE sheet.sheetId = ind.sheetId
        ), 0) AS numeric), 2);

		UPDATE book
        SET quantity = quantity + amount
        WHERE bookId = book_id;


		SELECT importPrice INTO max_price
		FROM sheet_detail sd
		WHERE SD.sheetId = sheet_id AND book_id = sd.bookId
		ORDER BY importPrice DESC
		LIMIT 1;

        UPDATE book
        SET salePrice = ROUND(CAST(COALESCE((
            max_price
        ), 0) AS numeric) * 1.1, 2)
        WHERE bookId = book_id;

    END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_after_sheetDetail_insert
AFTER INSERT ON sheet_detail
FOR EACH ROW
EXECUTE FUNCTION trg_after_sheetDetail_insert(); 

CREATE OR REPLACE FUNCTION trg_after_sheetDetail_update()
RETURNS TRIGGER AS $$
DECLARE
    sheet_id CHAR(15);
	book_id CHAR(14);
	import_price FLOAT;
	max_price FLOAT;
	amount_old INT;
	amount_new INT;
BEGIN
    FOR sheet_id, import_price, book_id, amount_new, amount_old IN SELECT NEW.sheetId, NEW.importPrice, NEW.bookId, NEW.quantity, OLD.quantity
    LOOP
        UPDATE sheet
        SET totalCost = ROUND(CAST(COALESCE((
            SELECT SUM(quantity * importPrice)
            FROM sheet_detail ind
            WHERE sheet.sheetId = ind.sheetId
        ), 0) AS numeric), 2);

		UPDATE book
        SET quantity = quantity + (amount_new - amount_old)
        WHERE bookId = book_id;

		SELECT importPrice INTO max_price
		FROM sheet_detail sd
		WHERE SD.sheetId = sheet_id AND book_id = sd.bookId
		ORDER BY importPrice DESC
		LIMIT 1;

        UPDATE book
        SET salePrice = ROUND(CAST(COALESCE((
            max_price
        ), 0) AS numeric) * 1.1, 2)
        WHERE bookId = book_id;

    END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_after_sheetDetail_update
AFTER UPDATE ON sheet_detail
FOR EACH ROW
EXECUTE FUNCTION trg_after_sheetDetail_update(); 

CREATE OR REPLACE FUNCTION trg_after_sheetDetail_delete()
RETURNS TRIGGER AS $$
DECLARE
    sheet_id CHAR(15);
	book_id CHAR(14);
	import_price FLOAT;
	max_price FLOAT;
	amount INT;
BEGIN
    FOR sheet_id, import_price, book_id, amount IN SELECT NEW.sheetId, NEW.importPrice, NEW.bookId, NEW.quantity
    LOOP
        UPDATE sheet
        SET totalCost = ROUND(CAST(COALESCE((
            SELECT SUM(quantity * importPrice)
            FROM sheet_detail ind
            WHERE sheet.sheetId = ind.sheetId
        ), 0) AS numeric), 2);

		UPDATE book
        SET quantity = quantity - amount
        WHERE bookId = book_id;


		SELECT importPrice INTO max_price
		FROM sheet_detail sd
		WHERE SD.sheetId = sheet_id AND book_id = sd.bookId
		ORDER BY importPrice DESC
		LIMIT 1;

        UPDATE book
        SET salePrice = ROUND(CAST(COALESCE((
            max_price
        ), 0) AS numeric) * 1.1, 2)
        WHERE bookId = book_id;
    END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_after_sheetDetail_delete
AFTER DELETE ON sheet_detail
FOR EACH ROW
EXECUTE FUNCTION trg_after_sheetDetail_delete(); 

CREATE OR REPLACE FUNCTION trg_after_book_insert()
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
        ORDER BY sd.importPrice DESC
        LIMIT 1;

        UPDATE book
		SET salePrice = CASE WHEN new_sale_price IS NULL THEN 0
                    		ELSE ROUND(CAST(COALESCE((
            new_sale_price
        ), 0) AS numeric) * 1.1, 2)
                		END
		WHERE bookId = book_id;
    END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_after_book_insert
AFTER INSERT ON BOOK
FOR EACH ROW
EXECUTE FUNCTION trg_after_book_insert();

CREATE OR REPLACE FUNCTION trg_after_book_update()
RETURNS TRIGGER AS $$
DECLARE
	book_id CHAR(14);
	sale_price FLOAT;
BEGIN
    FOR book_id, sale_price IN SELECT NEW.bookId, NEW.salePrice
    LOOP
        UPDATE invoice_detail
		SET cost = sale_price
		WHERE bookId = book_id;
    END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_after_book_update
AFTER UPDATE of salePrice ON BOOK
FOR EACH ROW
EXECUTE FUNCTION trg_after_book_update();

CREATE OR REPLACE FUNCTION trg_before_book_insert()
RETURNS TRIGGER AS $$
DECLARE
	book_id CHAR(14);
	book_edition INT;
	book_title varchar(128);
BEGIN
    FOR book_id, book_title, book_edition IN SELECT NEW.bookId, NEW.title, NEW.bookEdition
    LOOP
        IF exists(select 1 from book where book_edition = bookEdition and book_title ILIKE title) THEN
			RAISE EXCEPTION 'The book which has title: %, edition: %  already exists', NEW.title, NEW.bookEdition;
        	RETURN NULL;
		END IF;
    END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_before_book_insert
BEFORE INSERT ON BOOK
FOR EACH ROW
EXECUTE FUNCTION trg_before_book_insert();

CREATE OR REPLACE FUNCTION trg_after_invoiceDetail_updateOrInsert()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE invoice_detail
    SET cost = ROUND(CAST((
		quantity * (
			SELECT salePrice FROM book 
			WHERE invoice_detail.bookId = book.bookId
    )) AS numeric), 2)
	WHERE invoice_detail.invoiceId = NEW.invoiceId;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_after_invoiceDetail_updateOrInsert
AFTER UPDATE OF quantity OR INSERT ON invoice_detail
FOR EACH ROW
EXECUTE FUNCTION trg_after_invoiceDetail_updateOrInsert();


CREATE OR REPLACE FUNCTION trg_after_invoice_insert()
RETURNS TRIGGER AS $$
DECLARE
    invoiceId CHAR(15);
BEGIN
    FOR invoiceId IN SELECT NEW.invoiceId
    LOOP
        UPDATE invoice
        SET total = ROUND(CAST(COALESCE((
            SELECT SUM(cost)
            FROM invoice_detail ind
            WHERE invoice.invoiceId = ind.invoiceId
        ), 0) AS numeric), 2);
    END LOOP;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_after_invoice_insert
AFTER INSERT ON invoice
FOR EACH ROW
EXECUTE FUNCTION trg_after_invoice_insert(); 

CREATE OR REPLACE TRIGGER trg_after_invoiceDetail_insert
AFTER INSERT OR DELETE OR UPDATE ON invoice_detail
FOR EACH ROW
EXECUTE FUNCTION trg_after_invoice_insert();

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



CREATE OR REPLACE FUNCTION insertMember(
    p_memberName VARCHAR(255),
    p_dob DATE,
	p_phoneNumber CHAR(11),
	p_gender VARCHAR(10)
) RETURNS void
AS $$
	BEGIN
		INSERT INTO member(memberName, dob, phoneNumber, gender)
		VALUES(p_memberName, p_dob, p_phoneNumber, p_gender);
	END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION insertAdministrator(
    p_adminName VARCHAR(255),
    p_dob DATE,
	p_phoneNumber CHAR(11),
	p_pwd VARCHAR(255),
	p_gender VARCHAR(10)
) RETURNS void
AS $$
	BEGIN
		INSERT INTO administrator(adminName, dob, phoneNumber, pwd, gender)
		VALUES(p_adminName, p_dob, p_phoneNumber, p_pwd, p_gender);
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
	_edition INT,
	_isHide BOOLEAN
) RETURNS void
AS $$
BEGIN
	INSERT INTO book(
	publisherId,
	title,
	bookEdition,
	isHide)
	VALUES (
	_publisherId,
	_title,
	_edition,
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
    _memberId CHAR(16),
	_empId char(16),
    _saleDate DATE
) RETURNS CHAR(15)
AS $$
DECLARE
    NewInvoiceId CHAR(15);
BEGIN
    INSERT INTO invoice(memberId, empId, saleDate)
    VALUES (_memberId, _empId, _saleDate)
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
	PERFORM insertEmp('Thuc Doan', '2003-01-01', '01234567890', '1234567', 'male', false);

	PERFORM insertMember('Sophie Johnson', '1993-08-12', '45678901234', 'female');
	PERFORM insertMember('Christopher White', '1998-02-28', '56789012345', 'male');
	PERFORM insertMember('Melissa Harris', '1990-11-15', '67890123456', 'female');
	PERFORM insertMember('David Turner', '1985-05-22', '78901234567', 'male');
	PERFORM insertMember('Ella Walker', '1997-04-18', '89012345678', 'female');
	PERFORM insertMember('Jacob Miller', '1986-09-03', '90123456789', 'male');
	PERFORM insertMember('Abigail Wilson', '1994-12-08', '34567890123', 'male');
	PERFORM insertMember('Nathan Davis', '1989-07-25', '23456789012', 'male');
	PERFORM insertMember('Madison Smith', '1996-03-10', '87654321098', 'female');
	PERFORM insertMember('Caleb Johnson', '1988-01-05', '98765432109', 'female');
	PERFORM insertMember('Hailey Brown', '1992-06-20', '67000123456', 'female');
	PERFORM insertMember('Vinh Thai', '2002-06-25', '12345678901', 'female');

	PERFORM insertAuthor('J.K. Rowling', 'female', false);
	PERFORM insertAuthor('George R.R. Martin', 'male', true);
	PERFORM insertAuthor('Agatha Christie', 'female', false);
	PERFORM insertAuthor('Jane Austen', 'female', true);
	PERFORM insertAuthor('Stephen King', 'male', false);
	PERFORM insertAuthor('J.R.R. Tolkien', 'female', true);
	PERFORM insertAuthor('Dan Brown', 'male', false);
	PERFORM insertAuthor('Harper Lee', 'male', true);
	PERFORM insertAuthor('J.D. Salinger', 'female', false);
	PERFORM insertAuthor('Gabriel Garcia Marquez', 'male', true);

	PERFORM insertAdministrator('Hau Nguyen', '2000-05-22', '23456789012', '1234567', 'male');
	PERFORM insertAdministrator('Minh Nguyen', '2003-05-22', '34567890123', '1234567', 'male');
	PERFORM insertAdministrator('Anh Nguyen', '2002-05-22', '45678901234', '1234567', 'male');

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

	PERFORM insertBook(publisher_id_1, 'Harry Potter and the Sorcerer''s Stone', 1, false);
	PERFORM insertBook(publisher_id_1, 'Harry Potter and the Sorcerer''s Stone', 2, false);
	PERFORM insertBook(publisher_id_2, 'A Game of Thrones', 1, true);
	PERFORM insertBook(publisher_id_3, 'Murder on the Orient Express', 1, false);
	PERFORM insertBook(publisher_id_4, 'Pride and Prejudice', 1, true);
	PERFORM insertBook(publisher_id_5, 'The Shining', 1, false);
	PERFORM insertBook(publisher_id_1, 'The Hobbit', 1, false);
	PERFORM insertBook(publisher_id_1, 'The Hobbit', 2, false);
	PERFORM insertBook(publisher_id_2, 'The Da Vinci Code', 1, true);
	PERFORM insertBook(publisher_id_3, 'To Kill a Mockingbird', 1, false);
	PERFORM insertBook(publisher_id_4, 'The Catcher in the Rye', 1, false);
	PERFORM insertBook(publisher_id_5, 'One Hundred Years of Solitude', 1, true);
	PERFORM insertBook(publisher_id_5, 'One Hundred Years of Solitude', 2, true);
	PERFORM insertBook(publisher_id_1, 'The Old Man and the Sea', 1, false);
	PERFORM insertBook(publisher_id_2, 'The Handmaid''s Tale', 1, true);
	PERFORM insertBook(publisher_id_2, 'The Handmaid''s Tale', 2, true);
	PERFORM insertBook(publisher_id_2, 'The Handmaid''s Tale', 3, true);
	PERFORM insertBook(publisher_id_3, 'Charlie and the Chocolate Factory', 1, false);
	PERFORM insertBook(publisher_id_4, 'Moby-Dick', 1, false);
	PERFORM insertBook(publisher_id_5, 'War and Peace', 1, true);

	RETURN;
END $$;

DO $$ 
DECLARE 
    bookId_1_1 CHAR(14);
    bookId_1_2 CHAR(14);
    bookId_2 CHAR(14);
    bookId_3 CHAR(14);
    bookId_4 CHAR(14);
    bookId_5 CHAR(14);
    bookId_6_1 CHAR(14);
    bookId_6_2 CHAR(14);
    bookId_7 CHAR(14);
    bookId_8 CHAR(14);
    bookId_9 CHAR(14);
    bookId_10_1 CHAR(14);
    bookId_10_2 CHAR(14);
    bookId_11 CHAR(14);
    bookId_12_1 CHAR(14);
    bookId_12_2 CHAR(14);
    bookId_12_3 CHAR(14);
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
    SELECT bookId INTO bookId_1_1 FROM book WHERE title = 'Harry Potter and the Sorcerer''s Stone' and bookEdition = 1;
    SELECT bookId INTO bookId_1_2 FROM book WHERE title = 'Harry Potter and the Sorcerer''s Stone' and bookEdition = 2;
    SELECT bookId INTO bookId_2 FROM book WHERE title = 'A Game of Thrones';
    SELECT bookId INTO bookId_3 FROM book WHERE title = 'Murder on the Orient Express';
    SELECT bookId INTO bookId_4 FROM book WHERE title = 'Pride and Prejudice';
    SELECT bookId INTO bookId_5 FROM book WHERE title = 'The Shining';
    SELECT bookId INTO bookId_6_1 FROM book WHERE title = 'The Hobbit' and bookEdition = 1;
    SELECT bookId INTO bookId_6_2 FROM book WHERE title = 'The Hobbit' and bookEdition = 2;
    SELECT bookId INTO bookId_7 FROM book WHERE title = 'The Da Vinci Code';
    SELECT bookId INTO bookId_8 FROM book WHERE title = 'To Kill a Mockingbird';
    SELECT bookId INTO bookId_9 FROM book WHERE title = 'The Catcher in the Rye';
    SELECT bookId INTO bookId_10_1 FROM book WHERE title = 'One Hundred Years of Solitude' and bookEdition = 1;
    SELECT bookId INTO bookId_10_2 FROM book WHERE title = 'One Hundred Years of Solitude' and bookEdition = 2;
    SELECT bookId INTO bookId_11 FROM book WHERE title = 'The Old Man and the Sea';
    SELECT bookId INTO bookId_12_1 FROM book WHERE title = 'The Handmaid''s Tale' and bookEdition = 1;
    SELECT bookId INTO bookId_12_2 FROM book WHERE title = 'The Handmaid''s Tale' and bookEdition = 2;
    SELECT bookId INTO bookId_12_3 FROM book WHERE title = 'The Handmaid''s Tale' and bookEdition = 3;
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

	PERFORM insertBookCategory(genreId_1, bookId_1_1);
	PERFORM insertBookCategory(genreId_2, bookId_1_1);
	PERFORM insertBookCategory(genreId_3, bookId_1_1);
	PERFORM insertBookCategory(genreId_1, bookId_1_2);
	PERFORM insertBookCategory(genreId_2, bookId_1_2);
	PERFORM insertBookCategory(genreId_3, bookId_1_2);

	PERFORM insertBookCategory(genreId_1, bookId_2);
	PERFORM insertBookCategory(genreId_3, bookId_2);
	PERFORM insertBookCategory(genreId_2, bookId_3);
	PERFORM insertBookCategory(genreId_5, bookId_4);
	PERFORM insertBookCategory(genreId_6, bookId_5);
	PERFORM insertBookCategory(genreId_7, bookId_5);

	PERFORM insertBookCategory(genreId_8, bookId_6_1);
	PERFORM insertBookCategory(genreId_8, bookId_6_2);

	PERFORM insertBookCategory(genreId_8, bookId_7);
	PERFORM insertBookCategory(genreId_9, bookId_7);
	PERFORM insertBookCategory(genreId_10, bookId_7);
	PERFORM insertBookCategory(genreId_12, bookId_7);

	PERFORM insertBookCategory(genreId_14, bookId_8);

	PERFORM insertBookCategory(genreId_16, bookId_9);
	PERFORM insertBookCategory(genreId_17, bookId_9);

	PERFORM insertBookCategory(genreId_18, bookId_10_1);
	PERFORM insertBookCategory(genreId_18, bookId_10_2);

	PERFORM insertBookCategory(genreId_19, bookId_11);

	PERFORM insertBookCategory(genreId_14, bookId_12_1);
	PERFORM insertBookCategory(genreId_15, bookId_12_1);
	PERFORM insertBookCategory(genreId_20, bookId_12_1);

	PERFORM insertBookCategory(genreId_14, bookId_12_2);
	PERFORM insertBookCategory(genreId_15, bookId_12_2);
	PERFORM insertBookCategory(genreId_20, bookId_12_2);

	PERFORM insertBookCategory(genreId_14, bookId_12_3);
	PERFORM insertBookCategory(genreId_15, bookId_12_3);
	PERFORM insertBookCategory(genreId_20, bookId_12_3);

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
    bookId_1_1 CHAR(14);
    bookId_1_2 CHAR(14);
    bookId_2 CHAR(14);
    bookId_3 CHAR(14);
    bookId_4 CHAR(14);
    bookId_5 CHAR(14);
    bookId_6_1 CHAR(14);
    bookId_6_2 CHAR(14);
    bookId_7 CHAR(14);
    bookId_8 CHAR(14);
    bookId_9 CHAR(14);
    bookId_10_1 CHAR(14);
    bookId_10_2 CHAR(14);
    bookId_11 CHAR(14);
    bookId_12_1 CHAR(14);
    bookId_12_2 CHAR(14);
    bookId_12_3 CHAR(14);
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
    SELECT bookId INTO bookId_1_1 FROM book WHERE title = 'Harry Potter and the Sorcerer''s Stone' and bookEdition = 1;
    SELECT bookId INTO bookId_1_2 FROM book WHERE title = 'Harry Potter and the Sorcerer''s Stone' and bookEdition = 2;
    SELECT bookId INTO bookId_2 FROM book WHERE title = 'A Game of Thrones';
    SELECT bookId INTO bookId_3 FROM book WHERE title = 'Murder on the Orient Express';
    SELECT bookId INTO bookId_4 FROM book WHERE title = 'Pride and Prejudice';
    SELECT bookId INTO bookId_5 FROM book WHERE title = 'The Shining';
    SELECT bookId INTO bookId_6_1 FROM book WHERE title = 'The Hobbit' and bookEdition = 1;
    SELECT bookId INTO bookId_6_2 FROM book WHERE title = 'The Hobbit' and bookEdition = 2;
    SELECT bookId INTO bookId_7 FROM book WHERE title = 'The Da Vinci Code';
    SELECT bookId INTO bookId_8 FROM book WHERE title = 'To Kill a Mockingbird';
    SELECT bookId INTO bookId_9 FROM book WHERE title = 'The Catcher in the Rye';
    SELECT bookId INTO bookId_10_1 FROM book WHERE title = 'One Hundred Years of Solitude' and bookEdition = 1;
    SELECT bookId INTO bookId_10_2 FROM book WHERE title = 'One Hundred Years of Solitude' and bookEdition = 2;
    SELECT bookId INTO bookId_11 FROM book WHERE title = 'The Old Man and the Sea';
    SELECT bookId INTO bookId_12_1 FROM book WHERE title = 'The Handmaid''s Tale' and bookEdition = 1;
    SELECT bookId INTO bookId_12_2 FROM book WHERE title = 'The Handmaid''s Tale' and bookEdition = 2;
    SELECT bookId INTO bookId_12_3 FROM book WHERE title = 'The Handmaid''s Tale' and bookEdition = 3;
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
   

	PERFORM insertAuthorBook(authorId_1, bookId_1_1);
	PERFORM insertAuthorBook(authorId_2, bookId_1_1);
	PERFORM insertAuthorBook(authorId_3, bookId_1_1);
	PERFORM insertAuthorBook(authorId_1, bookId_1_2);
	PERFORM insertAuthorBook(authorId_2, bookId_1_2);
	PERFORM insertAuthorBook(authorId_3, bookId_1_2);

	PERFORM insertAuthorBook(authorId_1, bookId_2);
	PERFORM insertAuthorBook(authorId_3, bookId_2);
	PERFORM insertAuthorBook(authorId_2, bookId_3);
	PERFORM insertAuthorBook(authorId_5, bookId_4);
	PERFORM insertAuthorBook(authorId_6, bookId_5);
	PERFORM insertAuthorBook(authorId_7, bookId_5);
	PERFORM insertAuthorBook(authorId_8, bookId_6_1);
	PERFORM insertAuthorBook(authorId_8, bookId_6_2);
	PERFORM insertAuthorBook(authorId_8, bookId_7);
	PERFORM insertAuthorBook(authorId_9, bookId_7);
	PERFORM insertAuthorBook(authorId_10, bookId_7);
	PERFORM insertAuthorBook(authorId_2, bookId_7);
	PERFORM insertAuthorBook(authorId_4, bookId_8);
	PERFORM insertAuthorBook(authorId_6, bookId_9);
	PERFORM insertAuthorBook(authorId_7, bookId_9);

	PERFORM insertAuthorBook(authorId_8, bookId_10_1);
	PERFORM insertAuthorBook(authorId_8, bookId_10_2);

	PERFORM insertAuthorBook(authorId_9, bookId_11);

	PERFORM insertAuthorBook(authorId_4, bookId_12_1);
	PERFORM insertAuthorBook(authorId_5, bookId_12_1);
	PERFORM insertAuthorBook(authorId_10, bookId_12_1);

	PERFORM insertAuthorBook(authorId_4, bookId_12_2);
	PERFORM insertAuthorBook(authorId_5, bookId_12_2);
	PERFORM insertAuthorBook(authorId_10, bookId_12_2);

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

	bookId_1_1 CHAR(14);
    bookId_1_2 CHAR(14);
    bookId_2 CHAR(14);
    bookId_3 CHAR(14);
    bookId_4 CHAR(14);
    bookId_5 CHAR(14);
    bookId_6_1 CHAR(14);
    bookId_6_2 CHAR(14);
    bookId_7 CHAR(14);
    bookId_8 CHAR(14);
    bookId_9 CHAR(14);
    bookId_10_1 CHAR(14);
    bookId_10_2 CHAR(14);
    bookId_11 CHAR(14);
    bookId_12_1 CHAR(14);
    bookId_12_2 CHAR(14);
    bookId_12_3 CHAR(14);
    bookId_13 CHAR(14);
    bookId_14 CHAR(14);
    bookId_15 CHAR(14);
BEGIN
	SELECT sheetId INTO sheetId_1 FROM sheet WHERE importDate = '2023-03-05';
    SELECT sheetId INTO sheetId_2 FROM sheet WHERE importDate = '2023-03-10';
    SELECT sheetId INTO sheetId_3 FROM sheet WHERE importDate = '2023-03-15';
    SELECT sheetId INTO sheetId_4 FROM sheet WHERE importDate = '2023-03-20';
    SELECT sheetId INTO sheetId_5 FROM sheet WHERE importDate = '2023-03-25';

	SELECT bookId INTO bookId_1_1 FROM book WHERE title = 'Harry Potter and the Sorcerer''s Stone' and bookEdition = 1;
    SELECT bookId INTO bookId_1_2 FROM book WHERE title = 'Harry Potter and the Sorcerer''s Stone' and bookEdition = 2;
    SELECT bookId INTO bookId_2 FROM book WHERE title = 'A Game of Thrones';
    SELECT bookId INTO bookId_3 FROM book WHERE title = 'Murder on the Orient Express';
    SELECT bookId INTO bookId_4 FROM book WHERE title = 'Pride and Prejudice';
    SELECT bookId INTO bookId_5 FROM book WHERE title = 'The Shining';
    SELECT bookId INTO bookId_6_1 FROM book WHERE title = 'The Hobbit' and bookEdition = 1;
    SELECT bookId INTO bookId_6_2 FROM book WHERE title = 'The Hobbit' and bookEdition = 2;
    SELECT bookId INTO bookId_7 FROM book WHERE title = 'The Da Vinci Code';
    SELECT bookId INTO bookId_8 FROM book WHERE title = 'To Kill a Mockingbird';
    SELECT bookId INTO bookId_9 FROM book WHERE title = 'The Catcher in the Rye';
    SELECT bookId INTO bookId_10_1 FROM book WHERE title = 'One Hundred Years of Solitude' and bookEdition = 1;
    SELECT bookId INTO bookId_10_2 FROM book WHERE title = 'One Hundred Years of Solitude' and bookEdition = 2;
    SELECT bookId INTO bookId_11 FROM book WHERE title = 'The Old Man and the Sea';
    SELECT bookId INTO bookId_12_1 FROM book WHERE title = 'The Handmaid''s Tale' and bookEdition = 1;
    SELECT bookId INTO bookId_12_2 FROM book WHERE title = 'The Handmaid''s Tale' and bookEdition = 2;
    SELECT bookId INTO bookId_12_3 FROM book WHERE title = 'The Handmaid''s Tale' and bookEdition = 3;
    SELECT bookId INTO bookId_13 FROM book WHERE title = 'Charlie and the Chocolate Factory';
    SELECT bookId INTO bookId_14 FROM book WHERE title = 'Moby-Dick';
    SELECT bookId INTO bookId_15 FROM book WHERE title = 'War and Peace';

	PERFORM insertSheetDetail(sheetId_1, bookId_1_1, 300, 20);
	PERFORM insertSheetDetail(sheetId_1, bookId_2, 250, 25);
	PERFORM insertSheetDetail(sheetId_1, bookId_3, 100, 15.25);
	PERFORM insertSheetDetail(sheetId_1, bookId_4, 800, 18);

	PERFORM insertSheetDetail(sheetId_2, bookId_5, 400, 30);
	PERFORM insertSheetDetail(sheetId_2, bookId_1_2, 480, 25);
	PERFORM insertSheetDetail(sheetId_2, bookId_6_1, 210, 16);

	PERFORM insertSheetDetail(sheetId_3, bookId_7, 320, 24);
	PERFORM insertSheetDetail(sheetId_3, bookId_8, 430, 20);
	PERFORM insertSheetDetail(sheetId_3, bookId_9, 560, 28);
	PERFORM insertSheetDetail(sheetId_3, bookId_6_2, 145, 21);
	PERFORM insertSheetDetail(sheetId_3, bookId_12_1, 256, 12.5);

	PERFORM insertSheetDetail(sheetId_4, bookId_10_1, 800, 32);
	PERFORM insertSheetDetail(sheetId_4, bookId_11, 750, 19.50);
	PERFORM insertSheetDetail(sheetId_4, bookId_12_1, 1000, 18.50);
	PERFORM insertSheetDetail(sheetId_4, bookId_12_2, 320, 14);

	PERFORM insertSheetDetail(sheetId_5, bookId_1_1, 50, 26);
	PERFORM insertSheetDetail(sheetId_5, bookId_10_2, 750, 46);
	PERFORM insertSheetDetail(sheetId_5, bookId_2, 50, 26);
	PERFORM insertSheetDetail(sheetId_5, bookId_12_3, 160, 18);
	PERFORM insertSheetDetail(sheetId_5, bookId_13, 300, 26.50);
	PERFORM insertSheetDetail(sheetId_5, bookId_14, 100, 22.50);
	PERFORM insertSheetDetail(sheetId_5, bookId_15, 50, 26);

	RETURN;
END $$;

DO $$ 
DECLARE 
	memberId_1 CHAR(16);
    memberId_2 CHAR(16);
    memberId_3 CHAR(16);
    memberId_4 CHAR(16);
    memberId_5 CHAR(16);
    memberId_6 CHAR(16);
    memberId_7 CHAR(16);
    memberId_8 CHAR(16);
    memberId_9 CHAR(16);
    memberId_10 CHAR(16);

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

	bookId_1_1 CHAR(14);
    bookId_1_2 CHAR(14);
    bookId_2 CHAR(14);
    bookId_3 CHAR(14);
    bookId_4 CHAR(14);
    bookId_5 CHAR(14);
    bookId_6_1 CHAR(14);
    bookId_6_2 CHAR(14);
    bookId_7 CHAR(14);
    bookId_8 CHAR(14);
    bookId_9 CHAR(14);
    bookId_10_1 CHAR(14);
    bookId_10_2 CHAR(14);
    bookId_11 CHAR(14);
    bookId_12_1 CHAR(14);
    bookId_12_2 CHAR(14);
    bookId_12_3 CHAR(14);
    bookId_13 CHAR(14);
    bookId_14 CHAR(14);
    bookId_15 CHAR(14);

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

	SELECT bookId INTO bookId_1_1 FROM book WHERE title = 'Harry Potter and the Sorcerer''s Stone' and bookEdition = 1;
    SELECT bookId INTO bookId_1_2 FROM book WHERE title = 'Harry Potter and the Sorcerer''s Stone' and bookEdition = 2;
    SELECT bookId INTO bookId_2 FROM book WHERE title = 'A Game of Thrones';
    SELECT bookId INTO bookId_3 FROM book WHERE title = 'Murder on the Orient Express';
    SELECT bookId INTO bookId_4 FROM book WHERE title = 'Pride and Prejudice';
    SELECT bookId INTO bookId_5 FROM book WHERE title = 'The Shining';
    SELECT bookId INTO bookId_6_1 FROM book WHERE title = 'The Hobbit' and bookEdition = 1;
    SELECT bookId INTO bookId_6_2 FROM book WHERE title = 'The Hobbit' and bookEdition = 2;
    SELECT bookId INTO bookId_7 FROM book WHERE title = 'The Da Vinci Code';
    SELECT bookId INTO bookId_8 FROM book WHERE title = 'To Kill a Mockingbird';
    SELECT bookId INTO bookId_9 FROM book WHERE title = 'The Catcher in the Rye';
    SELECT bookId INTO bookId_10_1 FROM book WHERE title = 'One Hundred Years of Solitude' and bookEdition = 1;
    SELECT bookId INTO bookId_10_2 FROM book WHERE title = 'One Hundred Years of Solitude' and bookEdition = 2;
    SELECT bookId INTO bookId_11 FROM book WHERE title = 'The Old Man and the Sea';
    SELECT bookId INTO bookId_12_1 FROM book WHERE title = 'The Handmaid''s Tale' and bookEdition = 1;
    SELECT bookId INTO bookId_12_2 FROM book WHERE title = 'The Handmaid''s Tale' and bookEdition = 2;
    SELECT bookId INTO bookId_12_3 FROM book WHERE title = 'The Handmaid''s Tale' and bookEdition = 3;
    SELECT bookId INTO bookId_13 FROM book WHERE title = 'Charlie and the Chocolate Factory';
    SELECT bookId INTO bookId_14 FROM book WHERE title = 'Moby-Dick';
    SELECT bookId INTO bookId_15 FROM book WHERE title = 'War and Peace';

	SELECT memberId INTO memberId_1 FROM member WHERE memberName = 'Sophie Johnson';
	SELECT memberId INTO memberId_2 FROM member WHERE memberName = 'Christopher White';
    SELECT memberId INTO memberId_3 FROM member WHERE memberName = 'Melissa Harris';
    SELECT memberId INTO memberId_4 FROM member WHERE memberName = 'David Turner';
    SELECT memberId INTO memberId_5 FROM member WHERE memberName = 'Ella Walker';
    SELECT memberId INTO memberId_6 FROM member WHERE memberName = 'Jacob Miller';
    SELECT memberId INTO memberId_7 FROM member WHERE memberName = 'Abigail Wilson';
    SELECT memberId INTO memberId_8 FROM member WHERE memberName = 'Nathan Davis';
    SELECT memberId INTO memberId_9 FROM member WHERE memberName = 'Madison Smith';
    SELECT memberId INTO memberId_10 FROM member WHERE memberName = 'Caleb Johnson';
   
	SELECT insertInvoice(memberId_2, emp_id_1, '2023-03-05') INTO invoiceId_2;
	PERFORM insertInvoiceDetail(invoiceId_2, bookId_1_2, 2);
	PERFORM insertInvoiceDetail(invoiceId_2, bookId_2, 1);
	PERFORM insertInvoiceDetail(invoiceId_2, bookId_3, 1);
	PERFORM insertInvoiceDetail(invoiceId_2, bookId_6_1, 1);
	PERFORM insertInvoiceDetail(invoiceId_2, bookId_7, 2);
	PERFORM insertInvoiceDetail(invoiceId_2, bookId_8, 1);

	SELECT insertInvoice(memberId_3, emp_id_1, '2023-03-10') INTO invoiceId_3;
	PERFORM insertInvoiceDetail(invoiceId_3, bookId_3, 1);
	PERFORM insertInvoiceDetail(invoiceId_3, bookId_5, 1);
	PERFORM insertInvoiceDetail(invoiceId_3, bookId_6_2, 1);
	PERFORM insertInvoiceDetail(invoiceId_3, bookId_7, 3);
	PERFORM insertInvoiceDetail(invoiceId_3, bookId_14, 1);
	PERFORM insertInvoiceDetail(invoiceId_3, bookId_15, 1);

	SELECT insertInvoice(memberId_4, emp_id_2, '2023-03-15') INTO invoiceId_4;
	PERFORM insertInvoiceDetail(invoiceId_4, bookId_10_2, 3);
	PERFORM insertInvoiceDetail(invoiceId_4, bookId_11, 1);
	PERFORM insertInvoiceDetail(invoiceId_4, bookId_13, 1);
	
	SELECT insertInvoice(memberId_5, emp_id_3, '2023-03-20') INTO invoiceId_5;
	PERFORM insertInvoiceDetail(invoiceId_5, bookId_1_1, 1);
	PERFORM insertInvoiceDetail(invoiceId_5, bookId_3, 1);
	PERFORM insertInvoiceDetail(invoiceId_5, bookId_9, 1);
	PERFORM insertInvoiceDetail(invoiceId_5, bookId_12_3, 3);
	PERFORM insertInvoiceDetail(invoiceId_5, bookId_13, 1);
	PERFORM insertInvoiceDetail(invoiceId_5, bookId_15, 1);

	SELECT insertInvoice(memberId_6, emp_id_4, '2023-03-25') INTO invoiceId_6;
	PERFORM insertInvoiceDetail(invoiceId_6, bookId_3, 2);
	PERFORM insertInvoiceDetail(invoiceId_6, bookId_5, 2);
	PERFORM insertInvoiceDetail(invoiceId_6, bookId_6_1, 2);

	SELECT insertInvoice(memberId_7, emp_id_5, '2023-03-30') INTO invoiceId_7;
	PERFORM insertInvoiceDetail(invoiceId_7, bookId_7, 1);
	PERFORM insertInvoiceDetail(invoiceId_7, bookId_14, 2);
	PERFORM insertInvoiceDetail(invoiceId_7, bookId_15, 3);

	SELECT insertInvoice(memberId_8, emp_id_6, '2023-04-02') INTO invoiceId_8;
	PERFORM insertInvoiceDetail(invoiceId_8, bookId_2, 1);
	PERFORM insertInvoiceDetail(invoiceId_8, bookId_3, 2);
	PERFORM insertInvoiceDetail(invoiceId_8, bookId_4, 1);
	PERFORM insertInvoiceDetail(invoiceId_8, bookId_7, 2);
	PERFORM insertInvoiceDetail(invoiceId_8, bookId_8, 1);
	PERFORM insertInvoiceDetail(invoiceId_8, bookId_9, 3);

	SELECT insertInvoice(memberId_9, emp_id_2, '2023-04-07') INTO invoiceId_9;
	PERFORM insertInvoiceDetail(invoiceId_9, bookId_3, 1);
	
	SELECT insertInvoice(memberId_10, emp_id_1, '2023-04-12') INTO invoiceId_10;
	PERFORM insertInvoiceDetail(invoiceId_10, bookId_3, 1);
	PERFORM insertInvoiceDetail(invoiceId_10, bookId_15, 1);

	RETURN;
END $$;