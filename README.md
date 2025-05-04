# Clean Architecture Demo

## Mô tả dự án

**Clean Architecture Demo** là một RESTful API minh hoạ cách tổ chức mã nguồn theo _Clean Architecture_ với Spring Boot, JPA và SQL Server. Mục tiêu của dự án là:

- **Tách biệt rõ ràng** giữa các tầng nghiệp vụ (domain), use case (application) và các adapter (infrastructure, frameworks).
- **Dễ dàng mở rộng** và bảo trì: khi thêm tính năng hoặc thay đổi công nghệ, chỉ cần cập nhật adapter tương ứng mà không ảnh hưởng đến business logic.
- **Tăng khả năng kiểm thử**: các lớp nghiệp vụ và use case hoàn toàn độc lập, có thể viết unit test mà không cần khởi động Spring context hay kết nối database thật.

Dự án cung cấp các chức năng cơ bản về quản lý `User`:

1. **Tạo User**  
   - Endpoint: `POST /users`  
   - Tham số query: `name`, `email`  
   - Trả về đối tượng `User` có `id` sinh tự động (UUID)

2. **Lấy danh sách User**  
   - Endpoint: `GET /users`  
   - Trả về mảng các `User` đã tạo

3. **Lấy chi tiết User theo ID**  
   - Endpoint: `GET /users/{id}`  
   - Trả về đối tượng `User` hoặc `404 Not Found` nếu không tồn tại

### Kiến trúc tổng quan

![image](https://github.com/user-attachments/assets/be095c65-1f89-4890-b406-73d3cf78902b)
