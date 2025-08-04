# Livestream Backend API

Backend API cho ứng dụng livestream tương tự Twitch, được xây dựng với Spring Boot và PostgreSQL.

## 🚀 Tính năng

### ✅ Đã implement:
- **Authentication**: JWT-based authentication với access token + refresh token
- **User Management**: Đăng ký, đăng nhập, lấy profile, cập nhật profile
- **Database**: PostgreSQL với JPA/Hibernate
- **Security**: Spring Security, password hashing với BCrypt
- **CORS**: Configured cho frontend integration

### 🔄 Đang phát triển:
- Social features (follow/unfollow)
- Video management
- Streaming features
- Real-time features

## 🛠️ Tech Stack

- **Backend**: Spring Boot 3.5.4
- **Database**: PostgreSQL 15
- **Authentication**: JWT (JSON Web Tokens)
- **ORM**: JPA/Hibernate
- **Security**: Spring Security
- **Password Encoding**: BCrypt
- **Containerization**: Docker & Docker Compose

## 📦 Cài đặt và chạy

### Cách 1: Sử dụng Docker (Khuyến nghị)

1. **Clone repository**:
   ```bash
   git clone <repository-url>
   cd fakebackend
   ```

2. **Chạy với Docker Compose**:
   ```bash
   docker-compose up -d
   ```

   Lệnh này sẽ:
   - Khởi tạo PostgreSQL database (port 5432)
   - Khởi tạo pgAdmin (port 5050)
   - Build và chạy Spring Boot application (port 8080)

3. **Truy cập các services**:
   - **API Backend**: http://localhost:8080/api
   - **pgAdmin**: http://localhost:5050 (admin@admin.com / admin)
   - **PostgreSQL**: localhost:5432

### Cách 2: Chạy local (cần PostgreSQL)

1. **Cài đặt PostgreSQL**:
   - Tạo database: `livestream_db`
   - Username: `postgres`
   - Password: `password`

2. **Chạy Spring Boot**:
   ```bash
   ./mvnw.cmd spring-boot:run
   ```

## 📋 API Endpoints

### Authentication
```
POST /api/auth/register    # Đăng ký tài khoản mới
POST /api/auth/login       # Đăng nhập
POST /api/auth/refresh     # Refresh access token
POST /api/auth/logout      # Đăng xuất
```

### User Management
```
GET  /api/users/profile    # Lấy profile hiện tại
PUT  /api/users/profile    # Cập nhật profile
GET  /api/users/{id}       # Lấy thông tin user theo ID
```

## 🔐 Authentication Flow

1. **Đăng ký/Đăng nhập**: Client gửi credentials
2. **Server response**: 
   - Access token (trong response body) - lưu trong memory
   - Refresh token (trong HTTP-only cookie) - tự động gửi với requests
3. **Authenticated requests**: Include `Authorization: Bearer <access_token>`
4. **Token refresh**: Tự động refresh khi access token expired (401)

## 📊 Database Schema

### Users Table
- Profile information (username, email, bio, avatar...)
- Social stats (followers, following count)
- Stream info (live status, stream title, category...)
- Video stats

### Videos Table
- Video metadata (title, thumbnail, views...)
- Foreign key to users

### Refresh Tokens Table
- JWT refresh tokens với expiry
- Foreign key to users

### Follows Table
- Follow relationships between users
- Unique constraint (follower_id, following_id)

## 🧪 Testing

### Sample Accounts
Được tạo tự động trong database:

**Admin Account**:
- Username: `admin`
- Email: `admin@livestream.com`
- Password: `admin123`

**Test User**:
- Username: `testuser`
- Email: `user@livestream.com`
- Password: `user123`

### Example Requests

**Đăng nhập**:
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "usernameOrEmail": "admin",
    "password": "admin123"
  }'
```

**Lấy profile** (cần access token):
```bash
curl -X GET http://localhost:8080/api/users/profile \
  -H "Authorization: Bearer <your_access_token>"
```

## 🔧 Configuration

### Environment Variables
```bash
# Database
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/livestream_db
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=password

# JWT
JWT_SECRET=your-secret-key-here
```

### CORS Settings
Configured cho frontend development:
- Allowed origins: `http://localhost:3000`, `https://localhost:3000`
- Credentials: true (cho cookies)

## 📝 Development Notes

- **JPA DDL**: `spring.jpa.hibernate.ddl-auto=update` (tự động update schema)
- **Logging**: Debug level cho development
- **Security**: JWT tokens, BCrypt password hashing
- **Error Handling**: Basic exception handling (sẽ cải thiện)

## 🔄 Next Steps

1. Implement social features (follow/unfollow)
2. Add video upload và streaming endpoints
3. Real-time features với WebSocket
4. Enhanced error handling và validation
5. API documentation với Swagger
6. Unit và integration tests
7. Production configurations

## 🤝 Contributing

1. Fork repository
2. Tạo feature branch
3. Commit changes
4. Push và tạo Pull Request

## 📄 License

This project is licensed under the MIT License.