# Дипломный проект по автоматизации тестирования web

## 	Содержание

> ➠ Общая информация о проекте
>
> ➠ [Запуск тестов из терминала](#запуск-тестов-из-терминала)
>
> ➠ [Запуск тестов в Jenkins](#-удаленный-запуск-тестов-в-Jenkins)
>
> ➠ [Отчет о результатах тестирования в Allure Report](#-главная-страница-allure-отчета)
>
> ➠ [Тест кейсы в Allure Test Ops](#-тест-кейсы-в-allure-test-ops)
> 
> ➠ [Интеграция с Jira](#-интеграция-с-jira)
>
> ➠ [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
>
> ➠ [Web сайта MTS](#web-сайта-mts)
>
> ➠ [Покрытый функционал web приложения MTS](#покрытый-функционал-web-приложения-mts)
>
> ➠ [Технологический стек UI](#технологический-стек-ui)
>
> ➠ [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)
>


##  Общая информация о проекте

### Запуск тестов из терминала

### Локальный запуск тестов

#### Локальный запуск тестов с использованием параметров из property файла

```
gradle clean test -Denv={имя property файла в папке test.resources}
```

#### Локальный запуск тестов с использованием параметров из property файла test

```
gradle clean test
```

#### Описание параметров для запуска тестов

>
> -Dbrowser <code>название браузера</code>
>
> -DbrowserVersion  <code>версия браузера</code>
>
> -DbaseUrl <code>url стенда фронта</code>
>
> -DbrowserSize <code>разрешение браузера</code>
>
> -DwebRemoteUrl <code>url remote сервиса</code>
>

### Удаленный запуск тестов

#### Удалённый запуск через передачу параметров

```
gradle clean test 
-DwebRemoteUrl="${REMOTE_URL}"
-Dbrowser="${BROWSER}"
-DbrowserVersion="${BROWSER_VERSION}"
-DbrowserSize="${BROWSER_SIZE}"
-DbaseUrl="${BASE_URL}"
```


## <img width="4%" title="Jenkins" src="readme_design/logo/Jenkins.svg"> Удаленный запуск тестов в Jenkins

> Для запуска тестов используется параметризированная сборка

<p align="center">
<img title="Jenkins" src="readme_design/screens/Jenkins.png">
</p>

## <img width="4%" title="Allure_Report" src="readme_design/logo/Allure_Report.svg"> Главная страница allure отчета

<p align="center">
<img title="Allure_main" src="readme_design/screens/Allure_main.png">
</p>

### <img width="4%" title="Allure_Report" src="readme_design/logo/Allure_Report.svg"> Группировка тестов по проверяемому функционалу

<p align="center">
<img title="Allure_suits" src="readme_design/screens/Allure_suits.png">
</p>

### <img width="4%" title="Allure_Report" src="readme_design/logo/Allure_Report.svg"> Основной дашборд

<p align="center">
<img title="Allure_dashboard" src="readme_design/screens/Allure_dashboard.png">
</p>

### <img width="4%" title="Allure_testops" src="readme_design/logo/Allure_Test_Ops.svg"> Тест кейсы в Allure Test Ops
<p align="center">
<img title="Allure_testops" src="readme_design/screens/Allure_testops.png">
</p>

### <img width="4%" title="Allure_testops" src="readme_design/logo/jira.png"> Интеграция с Jira

<p align="center">
<img title="Allure_testops" src="readme_design/screens/Jira.png">
</p>

## <img width="4%" title="Telegram" src="readme_design/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

> После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне.
>
> Информация по настройке и использованию бота <code>https://github.com/qa-guru/allure-notifications</code>

<p align="center">
<img title="Telegram_notifications" src="readme_design/screens/Telegram_notifications.png">
</p>

## Web сайта MTS

###  Покрытый функционал web приложения MTS

> Разработаны автотесты на <code>UI</code>.
### UI

- [x] Работоспобность главной страницы и отображение отдельных блоков
- [x] Работу выподающего списка "Комбо"
- [x] Переход в "МТС Доступ"
- [x] Работоспобность слайдера на главной странице

### Технологический стек UI

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="readme_design/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="readme_design/logo/Java.svg">
<img width="6%" title="Selenide" src="readme_design/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="readme_design/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="readme_design/logo/Allure_Report.svg">
<img width="6%" title="Allure Test Ops" src="readme_design/logo/Allure_Test_Ops.svg">
<img width="6%" title="Gradle" src="readme_design/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="readme_design/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="readme_design/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="readme_design/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="readme_design/logo/Telegram.svg">
</p>

### В данном подпроекте автотесты написаны на <code>Java</code> с использованием <code>Selenide</code> для UI-тестов.
>
> <code>Selenoid</code> выполняет запуск браузеров в контейнерах <code>Docker</code>.
>
> <code>Allure Report</code> формирует отчет о запуске тестов.
>
> Для автоматизированной сборки проекта используется <code>Gradle</code>.
>
> В качестве библиотеки для модульного тестирования используется <code>JUnit 5</code>.
>
> <code>Jenkins</code> выполняет запуск тестов.
>
> После завершения прогона отправляются уведомления с помощью бота в <code>Telegram</code>.

## <img width="4%" title="Selenoid" src="readme_design/logo/Selenoid.svg"> Пример запуска теста в Selenoid

> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.

<p align="center">
<img title="Selenoid_gif" src="readme_design/gifs/Selenoid1.gif">
</p>

