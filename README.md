# Spring Boot Employee API

## :bulb: Proje Hakkında

Bu proje, Spring Boot kullanılarak geliştirilmiş bir RESTful Employee Yönetim API’sidir.

Projede iki farklı API sürümü bulunmaktadır:
- **v1:** in-memory veri yapısı kullanır (geçici veri saklama, uygulama kapanınca silinir)
- **v2:** H2 veritabanı kullanır (kalıcı veri saklama, uygulama yeniden başlasa da veri korunur)

<br>

## :gear: Kullanılan Teknolojiler
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (v2 için)
- Maven

> Uygulama varsayılan olarak `http://localhost:8080` adresi üzerinden çalışacaktır.

<br>

## :file_folder: Proje Yapısı

```
src/main/java/com/example/demo/
├─ config/
│  └─ WebConfig.java        	# Content negotiation ve JSON/XML ayarları
|
├─ controller/
│  ├─ EmployeeController.java   # v1 Controller (in-memory)
│  └─ EmployeeController2.java  # v2 Controller (H2 DB)
|
├─ entity/
│  └─ EmployeeEntity.java       # H2 veritabanı tablosu, JPA entity
|
├─ error/						# Exception Sınıfları
│  ├─ EmployeeNotFoundException.java
│  └─ RestResponseExceptionHandler.java
|
├─ model/
│  ├─ Employee.java				# API ile veri alışverişi yapılan model
│  └─ ErrorMessage.java			# Hata mesaj modeli
|
├─ repository/
│  └─ EmployeeRepository.java	# Spring Data JPA repository, CRUD operasyonları
|
├─ service/
│  ├─ EmployeeService.java			# Service interface
│  ├─ EmployeeImplamentation.java   # v1 servis
│  └─ EmployeeH2Implamentation.java # v2 servis
|
└─ DemoApplication.java			# Spring Boot uygulamasını başlatan ana sınıf
```

<br>

## :triangular_ruler: API Endpoints

### v1 (In-memory) - `/v1/employee`

| HTTP Method | Endpoint | Açıklama |
| ----------- | -------- | -------- |
| GET | `/v1/employee` | Tüm Employee’leri listeler | 
| GET | `/v1/employee/{id}`/{id} | ID'ye göre Employee getirir | 
| GET | `/v1/employee/myParam?id={id}` | Query param ile Employee getirir | 
| POST | `/v1/employee` | Yeni Employee ekler | 
| DELETE | `/v1/employee/{id}` | ID'ye göre Employee siler | 

### v2 (H2 Database) - `/v2/employee`

| HTTP Method | Endpoint | Açıklama |
| ----------- | -------- | -------- |
| GET | `/v2/employee` | Tüm Employee’leri listeler | 
| GET | `/v2/employee{id}`/{id} | ID'ye göre Employee getirir | 
| POST | `/v2/employee` | Yeni Employee ekler | 

<br>

## :floppy_disk: Model

Employee JSON Örneği :

```json
{
	"empID": "1",
	"empFirstName": "Berkay",
	"empLastName": "Gumrukcu",
	"empEmail": "berkay@example.com"
}
```

> Not: empDepartment alanı API yanıtında JSON’dan gizlidir (@JsonIgnoreProperties kullanılmıştır).

<br>

## :key: Önemli Notlar
- v1 sürümü geçici veri saklar; uygulama kapandığında tüm veriler silinir.
- v2 sürümü H2 veritabanına bağlıdır ve veriler kalıcıdır.
- H2 web konsolu ile veritabanını inceleyebilirsiniz: http://localhost:8080/h2-console
- Proje içerisindeki H2 veritabı dosyası : `employeedb` 
- API JSON ve XML formatlarını destekler (Content Negotiation).