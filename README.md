# Clean Architecture Demo

## Mô tả dự án

**Clean Architecture Demo** là một minh hoạ cách tổ chức mã nguồn theo kiến trúc _Clean Architecture_, sử dụng Spring Boot, JPA và SQL Server với mục tiêu là:

- **Tách biệt rõ ràng** giữa các tầng nghiệp vụ (domain), use case (application) và các adapter (infrastructure, frameworks).
- **Dễ dàng mở rộng và bảo trì**: khi thêm tính năng hoặc thay đổi công nghệ, chỉ cần cập nhật adapter tương ứng mà không ảnh hưởng đến business logic.
- **Tăng khả năng kiểm thử**: các lớp nghiệp vụ và use case hoàn toàn độc lập, có thể viết unit test mà không cần khởi động Spring context hay kết nối database thật.

## Tính năng
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

## Kiến trúc tổng quan
```
clean-architecture-demo/
├─ .mvn/                                                                # Maven wrapper config 
├─ src/
│ ├─ main/
│ │ ├─ java/com/example/cleanarchitecturedemo
│ │ │ ├─ adapters/                                                      # Controllers & Gateways
│ │ │ ├─ core/                                                          # Entities, Interfaces, Use Cases
│ │ │ ├─ frameworks/                                                    # DB, UI framework code
│ │ │ └─ CleanarchitecturedemoApplication.java
│ │ └─ resources/                                                       # application.properties, templates, static...
│ └─ test/                                                              # Unit & integration tests
├─ mvnw                                                                 # Maven wrapper script (Linux/Mac)
├─ mvnw.cmd                                                             # Maven wrapper script (Windows)
├─ pom.xml                                                              # Maven build file
└─ .gitignore
```
