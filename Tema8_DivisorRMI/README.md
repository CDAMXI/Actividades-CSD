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
**💻 Implementaciones**
```bash
// RestadorImpl.java
public class RestadorImpl extends UnicastRemoteObject implements Restador {
    public Integer restar(int a, int b) throws RemoteException {
        System.out.println("Método remoto restar llamado");
        return a - b;
    }
}

// DivisorImpl.java
public class DivisorImpl extends UnicastRemoteObject implements Divisor {
    public Resultado dividir(Restador restador, int dividendo, int divisor) throws RemoteException {
        System.out.println("Método remoto dividir llamado");
        Resultado res = new Resultado();
        if (divisor == 0) {
            res.error = true;
            return res;
        }
        res.resto = dividendo;
        while (res.resto >= divisor) {
            res.resto = restador.restar(res.resto, divisor);
            res.cociente++;
        }
        return res;
    }
}
```
**📦 Clases de soporte**
```bash
// Resultado.java
public class Resultado implements Serializable {
    int cociente = 0;
    int resto = 0;
    boolean error = false;
}

// ComprobadorDivision.java
public interface ComprobadorDivision {
    boolean comprobar(int a, int b, Resultado r);
}

// ComprobadorDivisionImpl.java
public class ComprobadorDivisionImpl implements ComprobadorDivision {
    public boolean comprobar(int a, int b, Resultado r) {
        return (a == (b * r.cociente + r.resto));
    }
}
```
## 📊 Salida esperada
```bash
✅ ServidorRestador: "Restador preparado"
✅ ServidorDivision: "Divisor preparado"
✅ Cliente: "división correcta"
```

## ⚠️ Notas importantes
1. Los servidores deben mantenerse en ejecución
2. Usar el mismo puerto en todos los componentes
3. Se requieren 3 terminales: 1 para RMI Registry, 1 para cada servidor
