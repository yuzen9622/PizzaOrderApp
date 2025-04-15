# Pizza 點餐 App

本專案是一款 Pizza 點餐應用程式，支援點餐流程、副餐選擇與店家管理等功能，提供流暢的使用者體驗與基本資料互動能力，適合用於餐飲類型 App 的初步實作練習。

## 功能介紹

### 1. 點餐流程

- **主畫面**

  - 顯示使用者目前點選的餐點與副餐內容。
  - 可快速檢視已選品項。

- **點餐畫面**

  - 可選擇主餐品項（Pizza）。
  - 點選後自動返回主畫面並更新顯示內容。

- **副餐畫面**
  - 可選擇副餐項目（如飲料、小點心）。
  - 點選後自動返回主畫面並更新顯示內容。

### 2. 店家管理功能

- **店家列表頁面（ListView）**
  - 顯示所有店家資訊，包括「店家名稱」、「電話號碼」，以及選擇性項目如圖片與地址。
- **新增店家**

  - 透過客製化 `AlertDialog` 新增店家資訊。

- **撥打電話功能**

  - 點選店家項目，會複製電話號碼並透過 `Intent` 進入打電話的畫面。

- **更新店家資料**
  - 長按店家項目可進行更新（如修改名稱、電話等資訊）。

### 3. 導覽功能

- 主畫面中提供按鈕或連結，可快速跳轉至：
  - 點主餐畫面
  - 點副餐畫面
  - 店家資訊頁面

---

## 專案結構

```├── .gitignore
├── .idea
├── .gitignore
├── codeStyles
│ ├── Project.xml
│ └── codeStyleConfig.xml
├── compiler.xml
├── deploymentTargetDropDown.xml
├── gradle.xml
├── inspectionProfiles
│ └── Project_Default.xml
├── kotlinc.xml
├── migrations.xml
└── misc.xml
├── app
├── .gitignore
├── build.gradle.kts
├── proguard-rules.pro
└── src
│ ├── androidTest
│ └── java
│ │ └── com
│ │ └── example
│ │ └── pizzaorderapp
│ │ └── ExampleInstrumentedTest.kt
│ ├── main
│ ├── AndroidManifest.xml
│ ├── java
│ │ └── com
│ │ │ └── example
│ │ │ └── pizzaorderapp
│ │ │ ├── MainActivity.kt
│ │ │ ├── OrderPizzaActivity.kt
│ │ │ ├── OrderSideActivity.kt
│ │ │ ├── StoreActivity.kt
│ │ │ └── ui
│ │ │ └── theme
│ │ │ ├── Color.kt
│ │ │ ├── Theme.kt
│ │ │ └── Type.kt
│ └── res
│ │ ├── drawable-v24
│ │ └── ic_launcher_foreground.xml
│ │ ├── drawable
│ │ └── ic_launcher_background.xml
│ │ ├── layout
│ │ ├── activity_main.xml
│ │ ├── activity_order_pizza.xml
│ │ ├── activity_order_side.xml
│ │ ├── activity_store.xml
│ │ ├── adapter_item.xml
│ │ └── store_diolag.xml
│ │ ├── mipmap-anydpi-v26
│ │ ├── ic_launcher.xml
│ │ └── ic_launcher_round.xml
│ │ ├── mipmap-hdpi
│ │ ├── ic_launcher.webp
│ │ └── ic_launcher_round.webp
│ │ ├── mipmap-mdpi
│ │ ├── ic_launcher.webp
│ │ └── ic_launcher_round.webp
│ │ ├── mipmap-xhdpi
│ │ ├── ic_launcher.webp
│ │ └── ic_launcher_round.webp
│ │ ├── mipmap-xxhdpi
│ │ ├── ic_launcher.webp
│ │ └── ic_launcher_round.webp
│ │ ├── mipmap-xxxhdpi
│ │ ├── ic_launcher.webp
│ │ └── ic_launcher_round.webp
│ │ ├── values
│ │ ├── colors.xml
│ │ ├── strings.xml
│ │ └── themes.xml
│ │ └── xml
│ │ ├── backup_rules.xml
│ │ └── data_extraction_rules.xml
│ └── test
│ └── java
│ └── com
│ └── example
│ └── pizzaorderapp
│ └── ExampleUnitTest.kt
├── build.gradle.kts
├── gradle.properties
├── gradle
├── libs.versions.toml
└── wrapper
│ ├── gradle-wrapper.jar
│ └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts
```

## 執行方式

1. 開啟 Android Studio 或其他支援 Android 的 IDE。
2. Clone 本專案：
   ```bash
   git clone https://github.com/your-username/pizza-order-app.git
   ```
