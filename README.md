# 🍕 Foodies - Online Food Delivery Application

Foodies is a full-stack online food delivery application built with modern technologies. It features a seamless user experience for ordering food, a robust admin panel for management, and a powerful Spring Boot backend.

---

## 📸 Screenshots

### Landing Page
![Landing Page](./project%20pic/landing%20page.png)

### Food Menu
![Menu](./project%20pic/menu.png)

### Shopping Cart
![Cart](./project%20pic/cart.png)

### Secure Login
![Login](./project%20pic/login%20page.png)

---

## 🚀 Features

### User Features
- **Modern UI/UX**: Clean and responsive design using React and Bootstrap.
- **Food Catalog**: Browse through various categories and food items.
- **Cart Management**: Add, remove, and update food items in the cart.
- **Secure Authentication**: JWT-based login and signup.
- **Real-time Notifications**: Instant feedback using React Toastify.
- **Payment Integration**: Secure payments powered by **Razorpay**.
- **Order Tracking**: View order status and history.

### Admin Features
- **Dashboard**: Overview of sales and orders.
- **Food Management**: Add, update, or remove food items.
- **Order Management**: Update order status (Processing, Out for Delivery, Delivered).
- **Image Uploads**: Integrated with **AWS S3** for reliable image storage.

---

## 🛠️ Tech Stack

### Frontend (User & Admin)
- **Framework**: React.js (Vite)
- **Styling**: Vanilla CSS, Bootstrap 5
- **Icons**: Bootstrap Icons
- **State Management**: React Hooks
- **Routing**: React Router DOM
- **HTTP Client**: Axios
- **Payments**: Razorpay Integration

### Backend
- **Framework**: Spring Boot 3.4.3
- **Language**: Java 21
- **Database**: MongoDB
- **Security**: Spring Security & JWT
- **Cloud Storage**: AWS S3 (for food images)
- **Payment SDK**: Razorpay Java SDK
- **Build Tool**: Maven

---

## 📁 Project Structure

```text
online-food-delivery-project/
├── foodies/            # React User Frontend
├── adminpanel/         # React Admin Panel
├── foodiesapi/         # Spring Boot Backend REST API
├── project pic/        # Application Screenshots
├── Uploads/            # Local storage (fallback)
├── food images/        # Static assets
└── foodies-app.jar     # Pre-built production JAR
```

---

## ⚡ Automation Scripts

The project includes several batch scripts to simplify development and deployment:

| Script | Description |
| :--- | :--- |
| `Start-Foodies.bat` | Starts the production application on `http://localhost:8080` |
| `Open-Admin.bat` | Opens the Admin Panel in your default browser |
| `Start-Admin-Dev.bat`| Starts the Admin Panel in development mode (Vite) |
| `Update-App.bat` | Rebuilds the entire project (Frontends + Backend) and updates the JAR |

---

## 🛠️ Setup & Installation

### Prerequisites
- **Node.js** (v18+)
- **Java JDK 21**
- **MongoDB** (Local or Atlas)
- **Maven**

---

## 👨‍💻 Developed By
**Satyam**
