-- Create database if not exists
-- CREATE DATABASE IF NOT EXISTS livestream_db;

-- Enable UUID extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create enum types
DO $$ BEGIN
    CREATE TYPE user_role AS ENUM ('USER', 'MODERATOR', 'ADMIN');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

DO $$ BEGIN
    CREATE TYPE user_gender AS ENUM ('MALE', 'FEMALE', 'OTHER');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

-- Users table will be created by Hibernate
-- Videos table will be created by Hibernate  
-- Refresh tokens table will be created by Hibernate
-- Follows table will be created by Hibernate

-- Insert sample admin user (password: admin123)
INSERT INTO users (id, username, email, password_hash, role, created_at, updated_at) 
VALUES (
    uuid_generate_v4(),
    'admin',
    'admin@livestream.com',
    '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', -- bcrypt hash of 'admin123'
    'ADMIN',
    NOW(),
    NOW()
) ON CONFLICT DO NOTHING;

-- Insert sample user (password: user123)
INSERT INTO users (id, username, email, password_hash, role, created_at, updated_at) 
VALUES (
    uuid_generate_v4(),
    'testuser',
    'user@livestream.com', 
    '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', -- bcrypt hash of 'user123'
    'USER',
    NOW(),
    NOW()
) ON CONFLICT DO NOTHING;