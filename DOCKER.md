# Docker Setup cho Fake Backend Livestream

## Cách chạy ứng dụng với Docker

### Sử dụng Docker Compose (Khuyến nghị)

1. **Build và chạy ứng dụng:**
   ```bash
   docker-compose up -d --build
   ```

2. **Xem logs:**
   ```bash
   docker-compose logs -f fake-be-livestream
   ```

3. **Dừng ứng dụng:**
   ```bash
   docker-compose down
   ```

### Sử dụng Docker trực tiếp

1. **Build Docker image:**
   ```bash
   docker build -t fake-be-livestream .
   ```

2. **Chạy container:**
   ```bash
   docker run -d -p 8080:8080 --name fake-be-livestream fake-be-livestream
   ```

3. **Xem logs:**
   ```bash
   docker logs -f fake-be-livestream
   ```

4. **Dừng và xóa container:**
   ```bash
   docker stop fake-be-livestream
   docker rm fake-be-livestream
   ```

## Truy cập ứng dụng

- **API Endpoint:** http://localhost:8080
- **H2 Database Console:** http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Username: `sa`
  - Password: `password`

## Cấu hình

### Environment Variables

Bạn có thể override các cấu hình bằng environment variables:

```bash
docker run -d -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -e JWT_SECRET=your-custom-secret \
  -e JWT_EXPIRATION=86400000 \
  fake-be-livestream
```

### Custom Database

Để sử dụng PostgreSQL thay vì H2, uncomment phần postgres trong `docker-compose.yml` và thêm environment variables:

```yaml
environment:
  - SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/livestream_db
  - SPRING_DATASOURCE_USERNAME=livestream_user
  - SPRING_DATASOURCE_PASSWORD=livestream_password
  - SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.PostgreSQLDialect
```

## Troubleshooting

1. **Port đã được sử dụng:** Thay đổi port mapping trong docker-compose.yml từ `8080:8080` thành `8081:8080`

2. **Out of memory:** Tăng memory limit trong environment variables:
   ```yaml
   environment:
     - JAVA_OPTS=-Xmx1g -Xms512m
   ```

3. **Build failed:** Đảm bảo Docker có đủ disk space và internet connection để download dependencies

## Health Check

Container có health check endpoint tại: http://localhost:8080/actuator/health

Bạn có thể check status bằng lệnh:
```bash
docker-compose ps
```