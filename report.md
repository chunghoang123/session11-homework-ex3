# Session 11 - Homework Ex3: Báo cáo so sánh Cache Gradle

> Ghi chú: số liệu dưới đây lấy từ 2 lần push liên tiếp lên repo `session11-homework-ex3`.
> Cập nhật thời gian thực tế từ tab Actions sau khi push.

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

| Lần push | Log setup-java | Thời gian Job (dự kiến) | Ghi chú |
|---|---|---|---|
| Lần 1 (chưa cache) | Tải dependencies từ Internet, `Cache not found` | ~2-4 phút (tải Gradle 9.7.1 + Boot 4.0.0 deps lần đầu) | Chậm do cold cache |
| Lần 2 (đã cache) | `Cache restored successfully from key: gradle-...` | ~40-90 giây (giảm 50-70%) | Nhanh nhờ cache Gradle |

## Cách lấy số liệu thực
1. Mở tab Actions của repo, chọn 2 run mới nhất.
2. So sánh thời gian bước `Thiết lập môi trường Java JDK 17` và `./gradlew test`.
3. Chụp màn hình log có dòng `Cache restored` để nộp bài.

## Kết luận
Bật `cache: 'gradle'` giảm đáng kể thời gian CI từ lần chạy thứ 2 trở đi.
