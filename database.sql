CREATE DATABASE IF NOT EXISTS event_management;
USE event_management;

CREATE TABLE IF NOT EXISTS events (
                                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                      name VARCHAR(255) NOT NULL,
    type VARCHAR(100),
    description TEXT,
    organizer_name VARCHAR(255),
    organizer_contact VARCHAR(255),
    start_datetime DATETIME,
    end_datetime DATETIME,
    venue_name VARCHAR(255),
    venue_address TEXT,
    hall_name VARCHAR(255),
    capacity INT,
    category VARCHAR(255),
    ticket_required BOOLEAN,
    rsvp_deadline DATE,
    status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS attendees (
                                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                         first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(255) UNIQUE,
    mobile VARCHAR(50),
    gender VARCHAR(20),
    dob DATE,
    company VARCHAR(255),
    designation VARCHAR(255),
    address TEXT,
    city VARCHAR(100),
    country VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS tickets (
                                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                       event_id BIGINT,
                                       type VARCHAR(100),
    price DECIMAL(10,2),
    quantity_available INT,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS registrations (
                                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                             attendee_id BIGINT,
                                             ticket_id BIGINT,
                                             quantity INT,
                                             total_amount DECIMAL(10,2),
    registration_number VARCHAR(255),
    qr_code VARCHAR(255),
    status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (attendee_id) REFERENCES attendees(id),
    FOREIGN KEY (ticket_id) REFERENCES tickets(id)
    );

CREATE TABLE IF NOT EXISTS payments (
                                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                        registration_id BIGINT,
                                        amount DECIMAL(10,2),
    method VARCHAR(100),
    status VARCHAR(50),
    transaction_id VARCHAR(255),
    paid_at TIMESTAMP,
    FOREIGN KEY (registration_id) REFERENCES registrations(id)
    );

-- Sample data
INSERT INTO events (name, type, status)
VALUES ('Tech Conference', 'Conference', 'ACTIVE');

INSERT INTO tickets (event_id, type, price, quantity_available)
VALUES (1, 'VIP', 2000, 50);