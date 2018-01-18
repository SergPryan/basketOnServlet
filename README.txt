1. Создать базу mysql с именем demo. Настройки подключения к базе данных в файле src/main/resources/application.properties
2. Для создания таблиц и заполнения таблиц файл src/main/java/com.example.commons/create.sql
3. Чтобы собрать проект нужен maven. В папке выполнить команжу mvn package. В папке target появиться war файл.
4. War файл нужно установить в контейнер сервлетов tomcat версия 8.5.24