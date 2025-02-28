# Используем официальный образ OpenJDK 17 в качестве базового
FROM openjdk:17-jdk-slim AS build
# Устанавливаем рабочую директорию
WORKDIR /app
# Копируем файл jar приложения в контейнер
COPY app.jar .
# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]