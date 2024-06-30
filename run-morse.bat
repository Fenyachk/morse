@echo off

:: Установка переменной для пути к JAR-файлу
set JAR_PATH=%~dp0morse.jar

javac -d out/main src/morse/*.java


:: Проверка наличия JAR-файла
if not exist "%JAR_PATH%" (
    echo JAR-файл не найден. Пожалуйста, убедитесь, что morse.jar находится в той же директории, что и этот BAT-файл.
    pause
    exit /b 1
)

:: Запуск JAR-файла с Java
java -jar "%JAR_PATH%"

:: Ожидание перед закрытием консоли
pause
