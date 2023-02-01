## Проект "Сервис перевода денег"

### 1. Общая информация

Проект является демонстрацией возможностей интегарции серверной логики с имеющимся web приложением.
Front проекта честно стянут отсюда: [Сервис перевода денег](https://github.com/serp-ya/card-transfer.git)


### 2. Структура
Интеграция произведена посредством REST принципов на основе Spring mvc и Spring boot модулей согласно описанной спецификации: [Спецификация Front части проекта](https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml).

Согласно протоколу обмена запросами, созданы модели сущностей которые будет принимать приложение и которые будет возвращить.
Проект не использует внешние бд, сохранение и выдача информации по операциям происходит в рамках одной сессии, а информация сохраняется в коллекции HashMap.

Для корректного обмена запросами между модулями запущенными на разных портах сначала рассматривалась настройка прокси сервера на nginx,
но выбор в итоге пал на настройку spring контроллера с помощью аннотации: @CrossOrigin


### 3. Развертывание
Для упрощения развертывания модули с FRONT и BACK-END собраны в два собственных легковесных образа на основе linux с node.js 14й версии для первого b jdk17 для второго соответственно. 
Для упрощения запуска оба модуля собрыны в compose файл. Для развертывания нужно установить на хост docker, скопировать репозиторий в подготовленную директорию, и из нее запустить в терминале команду:
docker compose up - для сборки образов и их запуска, либо: docker compose build - только для сборки образов и запускать командой:
docker compose start

Запущенный проект будет доступен по адресу: http://localhost:3000/card-transfer

### 4. Логгирование транзакций
Логгирование в проекте устроено относительно просто, не используется внешних модулей, поэтому на хост не нужно дополнительно ничего устанавливать.
Через настройки спринга сделан вывод логов по транзакциям в консоль с помощью slf4j, в то же время в контейнере настроен сбор логов в локальный файл, 
который можно найти на linux хосте: /var/lib/docker/containers/<container-id>/<container-id.log>
либо на windows хосте в виртуальной среде:
\\wsl$\docker-desktop-data\data\docker\containers\<container-id>\local-logs\container.log


