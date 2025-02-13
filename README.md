# TestADLIndonesia
# 📘 API Automation Testing – OpenWeatherMap  
Project ini merupakan API automation testing menggunakan **Katalon Studio** untuk menguji skenario:
1. **5-Day Weather Forecast** di Jakarta Selatan.
2. **Current Air Pollution** di Jakarta Selatan.

Project ini menggunakan plugin eksternal **`org.everit.json.schema-1.14.2.jar`** untuk validasi JSON Schema.

---

## 📂 Project Structure  
```
KatalonStudioProject/
  ├── Test Cases/
  │     ├── Test_5DayWeatherForecast.groovy          # Test case untuk 5-Day Weather Forecast
  │     └── Test_CurrentAirPollution.groovy          # Test case untuk Current Air Pollution
  ├── Object Repository/
  │     ├── Get_5DayWeatherForecast.rs               # API request object untuk 5-Day Weather Forecast
  │     └── Get_CurrentAirPollution.rs               # API request object untuk Current Air Pollution
  ├── Test Suites/
  │     └── Tugas ADL Indonesia.ts                   # Test suite berisi dua test case di atas
  ├── Drivers/
  │     └── org.everit.json.schema-1.14.2.jar        # External JAR untuk validasi JSON Schema
  └── Reports/                                       # Folder untuk report hasil eksekusi
```

---

## 🚀 Steps to Run the Project  

### 1️⃣ **Clone the Project**  
Clone project dari GitHub:  
```sh
git clone https://github.com/username/katalon-api-testing.git
```

### 2️⃣ **Install External Library**  
Tambahkan **`org.everit.json.schema-1.14.2.jar`** ke Katalon Studio:  
1. **Drag and drop** file `org.everit.json.schema-1.14.2.jar` ke folder `Drivers/`.  
2. Buka menu **Project > Settings > External Libraries** di Katalon Studio.  
3. Klik **Add**, lalu pilih file `org.everit.json.schema-1.14.2.jar` dari folder `Drivers/`.  
4. Klik **OK** untuk menyimpan.

### 3️⃣ **Run Test Suite**  
- Buka Katalon Studio.  
- Di tab **Test Explorer**, buka folder **Test Suites** dan pilih **`Tugas ADL Indonesia`**.  
- Klik **Run** untuk menjalankan semua test case dalam test suite.  

### 4️⃣ **Monitor Log Viewer**  
Lihat hasil eksekusi di tab **Log Viewer**. Setiap test case akan menunjukkan status `PASSED` atau `FAILED`. Jika terjadi error, log akan menampilkan detail penyebabnya.

---

## 📊 How to Get the Report  
Setelah eksekusi selesai:  
1. Buka tab **Reports** di Katalon Studio.  
2. Pilih report untuk test suite `Tugas ADL Indonesia`.  
3. Klik **Export** untuk menyimpan hasil report dalam format **HTML** atau **PDF**.  

Jika report tidak muncul:  
- Pastikan **Katalon Report Plugin** sudah diinstal.  
- Eksekusi ulang test suite.

---

## ✅ Key Assertions in This Project  
### Test Case: `Test_5DayWeatherForecast`  
- **JSON Schema Validation**: Memastikan response sesuai dengan schema yang diharapkan.  
- **Response Body Check**: Memeriksa atribut penting seperti `temp`, `humidity`, dan `dt_txt`.  

### Test Case: `Test_CurrentAirPollution`  
- **Status Code Check**: Memastikan status code adalah `200`.  
- **Response Body Check**: Memeriksa koordinat (`lat`, `lon`), nilai `aqi`, serta komponen polusi udara (`co`, `no2`, `pm2_5`, `pm10`).  

---

## 📞 Support  
Jika ada pertanyaan, silakan hubungi [email@example.com](mailto:email@example.com).

