# Session 11 - Homework Ex3: Gradle Dependency Caching

Kế thừa Ex2, bổ sung `cache: 'gradle'` vào bước `actions/setup-java@v5` trong `.github/workflows/ci.yml:16`.

## Cách kiểm chứng cache
1. Push lần 1 (chưa cache): ghi lại thời gian Job, log `setup-java` tải dependencies.
2. Push lần 2 (đã cache): log `setup-java` hiện `Cache restored successfully from key: gradle-...`, thời gian `./gradlew test` giảm rõ.

Xem chi tiết so sánh trong `report.md`.
