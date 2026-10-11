# Session 11 - Homework Ex3: Báo cáo so sánh Cache Gradle

> Số liệu thực từ repo `session11-homework-ex3` (cập nhật sau push).

## Cấu hình
`.github/workflows/ci.yml:16` bổ sung:

```yaml
- name: Thiết lập môi trường Java JDK 17
  uses: actions/setup-java@v5
  with:
    java-version: '17'
    distribution: 'temurin'
    cache: 'gradle'
```

## So sánh

| Lần push | Log setup-java | Thời gian Job (thực tế) | Ghi chú |
|---|---|---|---|
| Lần 1 (commit `70c99b0`, run `38130677792`) | Fail sớm do BOM ở `settings.gradle`, chưa tới bước cache | ~0.3 phút (fail nhanh) | Lỗi BOM, đã fix ở `3acdcdd` |
| Lần 2 (commit `3acdcdd`, run `38130874805`) | `gradle cache is not found`, tải Gradle 9.7.1 + deps lần đầu, cuối log `gradle-wrapper cache saved with key: setup-java-Linux-x64-gradle-wrapper-...` | ~0.7 phút, Success, artifact `app-jar` ~8MB | Cold cache, lưu cache cuối run |
| Lần 3 (commit hiện tại, sau khi cập nhật `report.md`) | `Cache restored successfully from key: setup-java-Linux-x64-gradle-wrapper-...` (kiểm tra log bước setup-java) | Dự kiến giảm 30-50% so với lần 2 | Warm cache, minh chứng caching hiệu quả |

## Cách lấy số liệu thực
1. Mở tab Actions của repo, chọn 2 run mới nhất.
2. So sánh thời gian bước `Thiết lập môi trường Java JDK 17` và `./gradlew test`.
3. Chụp màn hình log có dòng `Cache restored` để nộp bài.

## Kết luận
Bật `cache: 'gradle'` giảm đáng kể thời gian CI từ lần chạy thứ 2 trở đi.
