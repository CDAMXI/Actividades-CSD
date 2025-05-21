# README - Sistema de División y Resta Remota con RMI

## 📌 Descripción
Sistema distribuido que realiza divisiones mediante restas sucesivas usando Java RMI. Incluye:
- Servidor de operaciones de resta (`Restador`)
- Servidor de división por restas (`Divisor`)
- Cliente de prueba

## 🛠️ Requisitos
- Java JDK 8+
- Terminal/bash

## 🚀 Instalación y Ejecución

1. **Compilar todo el proyecto**:
```bash
javac *.java
```
2. **Iniciar RMI Registry** (en puerto 1099):
```bash
rmiregistry 1099 &
```
3. **Ejecutar servidores** (en terminales separadas):
```bash
# Servidor de Restas
java ServidorRestador localhost 1099

# Servidor de Divisiones
java ServidorDivision localhost 1099
```
4. **Ejecutar Cliente:**
```bash
java Cliente localhost 1099
```
## 🏗️ Estructura del Código
**🔗 Interfaces remotas**
```bash
// Restador.java
public interface Restador extends Remote {
    Integer restar(int a, int b) throws RemoteException;
}

// Divisor.java
public interface Divisor extends Remote {
    Resultado dividir(Restador r, int a, int b) throws RemoteException;
}
```
